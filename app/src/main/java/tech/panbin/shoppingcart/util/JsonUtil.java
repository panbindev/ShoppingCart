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

    /*商品列表界面Json数据，Gson解析*/
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

    /*传数据给webView*/
    public static String handleCartDataToJsonString(List<BookInCart> mBookInCarts){
        Gson gson = new Gson();
        String jsonData = gson.toJson(mBookInCarts);
        return jsonData;
    }


    public static List<BookInCart> handleStringDataToList(String data){
        Gson gson = new Gson();
        ArrayList<BookInCart> bookInCarts = gson.fromJson(data, ArrayList.class);
        return bookInCarts;
    }

    /*解析与webview交互时收到的String数据*/
    public static BookInCart handleJsonStringToBookInCart(String data){
        Gson gson = new Gson();
        BookInCart bookInCart = gson.fromJson(data, BookInCart.class);
        return bookInCart;
    }

    /*把“59.00元”的字符串转为double型的"59.00"*/
    public static double handleGsonPriceToDouble(String gsonPrice){
        String price = gsonPrice.substring(0,gsonPrice.length()-1);
        double newPrice = Double.parseDouble(price);
        return newPrice;
    }

}
