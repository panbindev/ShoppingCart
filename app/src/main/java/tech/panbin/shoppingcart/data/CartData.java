package tech.panbin.shoppingcart.data;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tech.panbin.shoppingcart.gson.BooksGsonBean;
import tech.panbin.shoppingcart.model.BookInCart;
import tech.panbin.shoppingcart.util.JsonUtil;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by PanBin on 2018/03/15.
 */

public final class CartData {

    private static final String CART_DATA_TAG = "tech.panbin.android.CART_DATA";
    private static final String DATA_LIST_TAG = "BOOKS_IN_CART_LIST";
    private static final String DATA_MAP_TAG = "BOOKS_IN_CARS_MAP";

    /*DATA*/
    private static List<BookInCart> BOOKS_IN_CART_LIST = new ArrayList<>();

    /*key:bookId,value:position in list*/
    private static Map<String,Integer> BOOKS_IN_CARS_MAP = new HashMap<>();

    private static final void addCartData(BookInCart mBookInCart){
        String bookId = mBookInCart.getId();
        BOOKS_IN_CART_LIST.add(mBookInCart);
        int position = BOOKS_IN_CART_LIST.size() - 1;
        Integer p = new Integer(position);
        BOOKS_IN_CARS_MAP.put(bookId,p);
    }

    public static final void addBookToCart(BooksGsonBean mBooksGsonBean){
        BookInCart bookInCart = new BookInCart(mBooksGsonBean);
        addBookToCart(bookInCart);
    }

    public static final void addBookToCart(BookInCart bookInCart){
        addBookToCart(bookInCart,1);
    }

    /*n为负数表示减*/
    public static final void addBookToCart(BookInCart bookInCart,int n){
        String bookId = bookInCart.getId();

        if(BOOKS_IN_CARS_MAP.get(bookId)==null){
            bookInCart.setBookNumber(n);
            addCartData(bookInCart);
        }
        else{
            int position = BOOKS_IN_CARS_MAP.get(bookId);
            BOOKS_IN_CART_LIST.get(position).addBookNumber(n);
        }

    }


    public static final void saveCartData(Context mContext){

        if(!BOOKS_IN_CART_LIST.equals("null")){
//           String data = JsonUtil.handleCartDataToJsonString(BOOKS_IN_CART_LIST);
            Gson gson = new Gson();
            String jsonMap = gson.toJson(BOOKS_IN_CARS_MAP);
            String jsonList = gson.toJson(BOOKS_IN_CART_LIST);

            SharedPreferences sharedPreferences = mContext.getSharedPreferences(CART_DATA_TAG, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(DATA_MAP_TAG,jsonMap);
            editor.putString(DATA_LIST_TAG,jsonList);
            editor.commit();
        }
    }

    public static final void loadCartData(Context mContext){
        SharedPreferences pref = mContext.getSharedPreferences(CART_DATA_TAG,MODE_PRIVATE);
        String jsonMap = pref.getString(DATA_MAP_TAG,"null");
        String jsonList = pref.getString(DATA_LIST_TAG,"null");

        if(!jsonMap.equals("null")){
            Gson gson = new Gson();
            Type collectionType = new TypeToken<HashMap<String,Integer>>(){}.getType();
            HashMap<String,Integer> map = gson.fromJson(jsonMap, collectionType);
            BOOKS_IN_CARS_MAP = map;
        }

        if(!jsonList.equals("null")){
            Gson gson = new Gson();
            Type collectionType = new TypeToken<ArrayList<BookInCart>>(){}.getType();
            ArrayList<BookInCart> list = gson.fromJson(jsonList, collectionType);
            BOOKS_IN_CART_LIST = list;
        }
    }

    public static List<BookInCart> getBooksInCartList() {
        return BOOKS_IN_CART_LIST;
    }

    public static Map<String, Integer> getBooksInCarsMap() {
        return BOOKS_IN_CARS_MAP;
    }

}
