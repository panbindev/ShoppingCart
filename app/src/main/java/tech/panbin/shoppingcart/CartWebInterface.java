package tech.panbin.shoppingcart;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import java.util.List;

import tech.panbin.shoppingcart.data.CartData;
import tech.panbin.shoppingcart.gson.BooksGsonBean;
import tech.panbin.shoppingcart.model.BookInCart;
import tech.panbin.shoppingcart.util.JsonUtil;

import static android.content.ContentValues.TAG;

/**
 * Created by PanBin on 2018/03/15.
 */

@SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
public class CartWebInterface {

        Context mContext;


        /** Instantiate the interface and set the context */
        CartWebInterface(Context c) {
            mContext = c;
        }

        /** Show a toast from the web page */
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }

        // done: 2018/03/15 addBookToCart在showToast前就看不见toast了，原因未知
        /*原因查明：BookInCart类中，构造方法嵌套使用有误，造成实例化失败*/
        /*由商品列表页签调用*/
        @JavascriptInterface
        public void addToCart(String bookJson){
//                Log.d("webJson",bookJson);
//                this.showToast("添加成功");
                BooksGsonBean booksGsonBean = JsonUtil.handleBookJsonToGson(bookJson);

                String message = "《" + booksGsonBean.getTitle() + "》"+"添加成功";
                Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();

//                Log.d("debugData",booksGsonBean.getTitle());
//                BookInCart bookInCart = new BookInCart(booksGsonBean,1);
//                Log.d("debugData","bookInCart:  "+bookInCart.getTitle()+bookInCart.getPrice());

                CartData.addBookToCart(booksGsonBean);

//                Log.d("webGson",booksGsonBean.getTitle());
//                for(BookInCart bookInCart:CartData.getBooksInCartList()){
//                        Log.d("webGson", "addToCart: "+bookInCart.getTitle());
//                }
//                for(Integer integer:CartData.getBooksInCarsMap().values()){
//                        Log.d("webGson", "addToCart: "+integer);
//                }
        }

        @JavascriptInterface
        public String loadCartData(){
                String data = JsonUtil.handleCartDataToJsonString(CartData.getBooksInCartList());
                Log.d("webLoadData",data);
                Log.d("webLoadData", "demo");
                return data;
        }

        @JavascriptInterface
        public void alterProductNumber(String bookJson){
                BookInCart bookInCart = JsonUtil.handleJsonStringToBookInCart(bookJson);
                int newNumber = bookInCart.getBookNumber();
                CartData.addBookToCart(bookInCart,newNumber);
        }

        @JavascriptInterface
        public String countPrice(String selectedBookIdListJson){
                return null;
        }
}
