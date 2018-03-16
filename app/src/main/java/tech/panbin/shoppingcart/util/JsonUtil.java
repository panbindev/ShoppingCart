package tech.panbin.shoppingcart.util;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
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

    public static BookInCart handleJsonStringToBookInCart(String data){
        Gson gson = new Gson();
        BookInCart bookInCart = gson.fromJson(data, BookInCart.class);
        return bookInCart;
    }

}
