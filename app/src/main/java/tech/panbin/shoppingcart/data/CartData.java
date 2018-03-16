package tech.panbin.shoppingcart.data;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.EventLogTags;
import android.util.Log;

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

    public static final String CART_DATA_TAG = "CART_DATA";
    public static final String DATA_LIST_TAG = "BOOKS_IN_CART_LIST";
    public static final String DATA_MAP_TAG = "BOOKS_IN_CARS_MAP";
    public static final String DATA_SAVE_TAG = "CART_DATA_SAVE_BOOLEAN";

    public static final String DATA_DEBUG_TAG = "CART_DATA_DEBUG";

    /*DATA*/
    private static List<BookInCart> BOOKS_IN_CART_LIST = new ArrayList<>();

    /*key:bookId,value:position in list*/
    private static Map<String,Integer> BOOKS_IN_CARS_MAP = new HashMap<>();

    private static void addCartData(BookInCart mBookInCart){
        String bookId = mBookInCart.getId();
        BOOKS_IN_CART_LIST.add(mBookInCart);
        int position = BOOKS_IN_CART_LIST.size() - 1;
//        Integer p = Integer.valueOf(position);//IDE提示当前语言版本没必要这么写了
//        Log.d(DATA_DEBUG_TAG,"position:"+position+"  bookid:"+bookId+"  title"+mBookInCart.getTitle()+"  number:"+mBookInCart.getBookNumber());
        BOOKS_IN_CARS_MAP.put(bookId,position);
    }

    public static void addBookToCart(BooksGsonBean mBooksGsonBean){
        BookInCart bookInCart = new BookInCart(mBooksGsonBean);
        addBookToCart(bookInCart);
    }

    public static void addBookToCart(BookInCart bookInCart){
        addBookToCart(bookInCart,1);
    }

    /*n为需要设定的数目*/
    public static void addBookToCart(BookInCart bookInCart,int n){
        String bookId = bookInCart.getId();

        if(BOOKS_IN_CARS_MAP.get(bookId)==null){
            bookInCart.setBookNumber(n);
            addCartData(bookInCart);
        }
        else{
            int position = BOOKS_IN_CARS_MAP.get(bookId);
            BOOKS_IN_CART_LIST.get(position).setBookNumber(n);
        }
    }


    public static void saveCartData(Context mContext){

        if(!BOOKS_IN_CART_LIST.equals("null")){
//           String data = JsonUtil.handleCartDataToJsonString(BOOKS_IN_CART_LIST);
            Gson gson = new Gson();
            String jsonMap = gson.toJson(BOOKS_IN_CARS_MAP);
            String jsonList = gson.toJson(BOOKS_IN_CART_LIST);

            SharedPreferences sharedPreferences = mContext.getSharedPreferences(CART_DATA_TAG, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(DATA_MAP_TAG,jsonMap);
            editor.putString(DATA_LIST_TAG,jsonList);
            editor.putBoolean(DATA_SAVE_TAG,true);
            editor.apply();
        }
    }

    public static final void loadCartData(Context mContext){
        SharedPreferences pref = mContext.getSharedPreferences(CART_DATA_TAG,MODE_PRIVATE);
        String jsonMap = pref.getString(DATA_MAP_TAG,"null");
        String jsonList = pref.getString(DATA_LIST_TAG,"null");
        boolean isSaved = pref.getBoolean(DATA_SAVE_TAG,false);

        if(isSaved==true){
            Gson gson = new Gson();

            Type collectionTypeMap = new TypeToken<HashMap<String,Integer>>(){}.getType();
            HashMap<String,Integer> map = gson.fromJson(jsonMap, collectionTypeMap);
            BOOKS_IN_CARS_MAP = map;

            Type collectionTypeList = new TypeToken<ArrayList<BookInCart>>(){}.getType();
            ArrayList<BookInCart> list = gson.fromJson(jsonList, collectionTypeList);
            BOOKS_IN_CART_LIST = list;
        }
    }

    public static List<BookInCart> getBooksInCartList() {
        return BOOKS_IN_CART_LIST;
    }

    public static Map<String, Integer> getBooksInCarsMap() {
        return BOOKS_IN_CARS_MAP;
    }

    public static void setBooksInCartList(List<BookInCart> mBooksInCartList) {
        BOOKS_IN_CART_LIST = mBooksInCartList;
    }

    public static void setBooksInCarsMap(Map<String, Integer> mBooksInCarsMap) {
        BOOKS_IN_CARS_MAP = mBooksInCarsMap;
    }

}
