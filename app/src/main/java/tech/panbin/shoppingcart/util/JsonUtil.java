package tech.panbin.shoppingcart.util;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import tech.panbin.shoppingcart.gson.BooksGsonBean;
import tech.panbin.shoppingcart.model.BookInCart;

/**
 * Created by PanBin on 2018/03/15.
 */

public class JsonUtil {

    /*从webView获得商品列表Json数据，用Gson解析，保存到本地*/
    public static BooksGsonBean handleBookJsonToGson(String bookJson){

        try {
            JSONObject jsonObject = new JSONObject(bookJson);

            String BookContent = jsonObject.toString();

            return new Gson().fromJson(BookContent, BooksGsonBean.class);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /*将购物车中的某个商品对象，转为String，传数据给webView*/
    public static String handleCartDataToJsonString(List<BookInCart> mBookInCarts){
        Gson gson = new Gson();
        String jsonData = gson.toJson(mBookInCarts);
        return jsonData;
    }

//    /*最后决定传回String[] bookIdList，故此方法弃置不用*/
//    public static List<BookInCart> handleStringDataToList(String data){
//        Gson gson = new Gson();
//        ArrayList<BookInCart> bookInCarts = gson.fromJson(data, ArrayList.class);
//        return bookInCarts;
//    }

//    /*最后决定传回String[] bookIdList，故此方法弃置不用*/
//    /*解析Android原生与webview交互时收到的String数据*/
//    public static BookInCart handleJsonStringToBookInCart(String data){
//        Gson gson = new Gson();
//        BookInCart bookInCart = gson.fromJson(data, BookInCart.class);
//        return bookInCart;
//    }

    /*把型如“59.00元”的字符串去掉结尾汉字，并转为double型的数值*/
    public static double handleGsonPriceToDouble(String gsonPrice){
        String price = gsonPrice.substring(0,gsonPrice.length()-1);
        double newPrice = Double.parseDouble(price);
        return newPrice;
    }

}
