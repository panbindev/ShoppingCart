package tech.panbin.shoppingcart.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import java.util.List;

import tech.panbin.shoppingcart.model.BookInCart;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by PanBin on 2018/03/15.
 */

public final class CartData {

    /*本地存储标记*/
    private static final String CART_DATA_TAG = "CART_DATA";
    private static final String DATA_LIST_TAG = "BOOKS_IN_CART_LIST";
    private static final String DATA_SAVE_TAG = "CART_DATA_SAVE_BOOLEAN";

    /*当作本地运行时数据库使用，存储购物车列表数据*/
    private static List<BookInCart> BOOKS_IN_CART_LIST = new ArrayList<>();

    /*应用内部读取List数据*/
    public static List<BookInCart> getBooksInCartList() {
        return BOOKS_IN_CART_LIST;
    }

    /*应用内部设置List数据*/
    public static void setBooksInCartList(List<BookInCart> mBooksInCartList) {
        BOOKS_IN_CART_LIST = mBooksInCartList;
    }

    /*返回所查找的Book在list数组中的position,-1表示没找到*/
    public static int searchBookById(String bookId){

        for(int i=0;i<BOOKS_IN_CART_LIST.size();i++){
            if(BOOKS_IN_CART_LIST.get(i).getId().equals(bookId)){
                return i;
            }
        }
        return -1;
    }

    /*添加商品到购物车*/
    public static void addProductCart(BookInCart mBookInCart){
        int position = searchBookById(mBookInCart.getId());
        if(position==-1){
            BOOKS_IN_CART_LIST.add(mBookInCart);
        }
        else{
            int oldNumber = BOOKS_IN_CART_LIST.get(position).getBookNumber();
            int newNumber = oldNumber + 1;
            BOOKS_IN_CART_LIST.get(position).setBookNumber(newNumber);
        }
    }
    /*修改现有的购物车中商品的数量*/
    public static boolean alterNumberData(BookInCart mBookInCart){
        int position = searchBookById(mBookInCart.getId());
        if(position==-1){
            return false;
        }
        else{
            BOOKS_IN_CART_LIST.get(position).setBookNumber(mBookInCart.getBookNumber());
            return true;
        }
    }

    /*修改现有的购物车中商品的数量*/
    public static boolean alterNumberData(String bookId, int number){
        int position = searchBookById(bookId);
        if(position==-1){
            return false;
        }
        else{
            BOOKS_IN_CART_LIST.get(position).setBookNumber(number);
            return true;
        }
    }

    /*删除选定购物车列表的数据*/
    public static void deleteProductCart(String[] bookIdList){
        for (String id : bookIdList){
            int position = searchBookById(id);
            BOOKS_IN_CART_LIST.remove(position);
        }
    }

    /*清空数据，（清空购物车）*/
    public static void deleteAllCart(){
        BOOKS_IN_CART_LIST.clear();
    }

    /*保存购物车内数据到Android本地*/
    public static void saveCartData(Context mContext){
        Gson gson = new Gson();
        String jsonList = gson.toJson(BOOKS_IN_CART_LIST);

        SharedPreferences sharedPreferences = mContext.getSharedPreferences(CART_DATA_TAG, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(DATA_LIST_TAG,jsonList);
        editor.putBoolean(DATA_SAVE_TAG,true);
        editor.apply();
    }

    /*从本地加载数据*/
    public static final void loadCartData(Context mContext){
        SharedPreferences pref = mContext.getSharedPreferences(CART_DATA_TAG,MODE_PRIVATE);
        String jsonList = pref.getString(DATA_LIST_TAG,"null");
        boolean isSaved = pref.getBoolean(DATA_SAVE_TAG,false);

        if(isSaved==true){
            Gson gson = new Gson();
            Type collectionTypeList = new TypeToken<ArrayList<BookInCart>>(){}.getType();
            ArrayList<BookInCart> list = gson.fromJson(jsonList, collectionTypeList);
            BOOKS_IN_CART_LIST = list;
        }
    }
}
