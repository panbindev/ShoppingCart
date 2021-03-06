package tech.panbin.shoppingcart;

import android.annotation.SuppressLint;
import android.content.Context;

import android.webkit.JavascriptInterface;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.List;

import tech.panbin.shoppingcart.data.CartData;
import tech.panbin.shoppingcart.gson.BooksGsonBean;
import tech.panbin.shoppingcart.model.BookInCart;
import tech.panbin.shoppingcart.util.JsonUtil;

/**
 * Created by PanBin on 2018/03/15.
 */

@SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
public class CartWebInterface {

    Context mContext;

    /**
     * Instantiate the interface and set the context
     */
    CartWebInterface(Context c) {
        mContext = c;
    }

    /**
     * Show a toast from the web page
     */
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    /*从商品列表添加商品到购物车时，将数据存储到Android本地*/
    @JavascriptInterface
    public void addToCart(String bookJson) {
        BooksGsonBean booksGsonBean = JsonUtil.handleBookJsonToGson(bookJson);

        String message = "《" + booksGsonBean.getTitle() + "》" + "添加成功";
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();

        BookInCart bookInCart = new BookInCart(booksGsonBean);
        CartData.addProductCart(bookInCart);
    }

    /*打开webView购物车页面时，载入Android本地数据*/
    @JavascriptInterface
    public String loadCartData() {
        String data = JsonUtil.handleCartDataToJsonString(CartData.getBooksInCartList());
        return data;
    }

    /*购物车页面，商品数量发生改变时调用，更新Android本地内存数据*/
    @JavascriptInterface
    public void alterProductNumber(String bookId, int number) {
        boolean isSuccess = false;
        isSuccess = CartData.alterNumberData(bookId, number);
        if (isSuccess) {
            if(number!=0){
                Toast.makeText(mContext, "数据更新成功，当前数量为"+number, Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(mContext, "数据更新为0，自动删除该商品", Toast.LENGTH_SHORT).show();
            }

        }
    }

    /*
    * 求总价
    * 购物车列表中选中商品，webView将商品id传给android。
    * 商品id为String，从webview传回的是String [] bookIdList
    * 返回 String总价，例如“59.00元”
    */
    @JavascriptInterface
    public String getSumPrice(String strList) {
        /*购物车中选中的商品的列表*/
        String [] bookIdList = handleStringToStringList(strList);

        /*购物车内商品信息*/
        List<BookInCart> bookInCartList = CartData.getBooksInCartList();

        /*价格*/
        String strPrice;
        double numberPrice;

        /*数量*/
        double number;

        /*总价*/
        double sumPrice = 0;

        /*求总价*/
        for (int i = 0; i < bookIdList.length; i++) {

            /*根据购物车列表选中的id，找到商品信息*/
            int position = CartData.searchBookById(bookIdList[i]);

            /*为了计算价格，转换商品单价的数据格式*/
            strPrice = bookInCartList.get(position).getPrice();
            numberPrice = JsonUtil.handleGsonPriceToDouble(strPrice);

            /*商品数量*/
            number = (double) bookInCartList.get(position).getBookNumber();

            /*求总价*/
            sumPrice = sumPrice + (numberPrice * number);
        }

        /*转换价格格式为String型，例如“59.00元” */
        String printPrice;
        DecimalFormat df = new DecimalFormat("#.00");
        printPrice = df.format(sumPrice) + "元";
        return printPrice;
    }

    /*删除选中的商品
    *
    * 传入选中的所有商品的id，用“-”拼接
    * */
    @JavascriptInterface
    public void deleteSeletedProduct(String strList) {

        String [] bookIdList = handleStringToStringList(strList);
        CartData.deleteProductCart(bookIdList);
    }

    /*清空购物车
    *
    * 删除本地存储的购物车信息
    * */
    @JavascriptInterface
    public void deleteAll() {
        CartData.deleteAllCart();
    }

    /*处理传回的bookId列表
    *
    * 传入String
    * 样例 10213-10222
    * 用“-”分割bookId
    * */
    private String[] handleStringToStringList(String strFromWeb){
        String[] bookIdList = strFromWeb.split("-");
        return bookIdList;
    }
}
