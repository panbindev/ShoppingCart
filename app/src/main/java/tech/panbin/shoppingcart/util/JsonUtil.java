package tech.panbin.shoppingcart.util;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import tech.panbin.shoppingcart.gson.BooksGsonBean;
import tech.panbin.shoppingcart.model.BookInCart;

/**
 * Created by PanBin on 2018/03/15.
 */

public class JsonUtil {

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

    // TODO: 2018/03/15
    public static String handleBookCartGson(List<BookInCart> mBookInCarts){

//        try {
//            JSONObject jsonObject = new JSONObject();
//
//            String BookContent = jsonObject.toString();
//
//            return new Gson().fromJson(BookContent, BooksGsonBean.class);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return null;
    }

}
