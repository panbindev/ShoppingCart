package tech.panbin.shoppingcart.data;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

import tech.panbin.shoppingcart.gson.BooksGsonBean;
import tech.panbin.shoppingcart.model.BookInCart;
import tech.panbin.shoppingcart.util.JsonUtil;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by PanBin on 2018/03/15.
 */

public class CartData {

    public static final String CART_DATA = "tech.panbin.android.CART_DATA";
    public static List<BookInCart> mBookInCarts = new ArrayList<>();

    public static final void addBookToCart(String bookJson){
        BooksGsonBean booksGsonBean = JsonUtil.handleBookJsonToGson(bookJson);
        addBookToCart(booksGsonBean);
    }

    public static final void addBookToCart(BooksGsonBean mBooksGsonBean){

        boolean isInCart = false;
        String bookId = mBooksGsonBean.getId();

        for(int i=0;i<mBookInCarts.size();i++){
            if(mBookInCarts.get(i).equals(bookId)){
                isInCart = true;
                mBookInCarts.get(i).addBookNumber();
                break;
            }
        }

        if(isInCart==false)
        {
            BookInCart bookInCart = (BookInCart) mBooksGsonBean;
            bookInCart.setBookNumber(1);
            mBookInCarts.add(bookInCart);
        }
    }

    public static final void addBookNumber(String bookId){

        boolean isInCart = false;

        for(int i=0;i<mBookInCarts.size();i++){
            if(mBookInCarts.get(i).equals(bookId)){
                isInCart = true;
                mBookInCarts.get(i).addBookNumber();
                break;
            }
        }
    }

    public static final void subBookNumber(String bookId){

        boolean isInCart = false;
        int number;

        for(int i=0;i<mBookInCarts.size();i++){
            if(mBookInCarts.get(i).equals(bookId)){
                isInCart = true;
                number = mBookInCarts.get(i).getBookNumber();

                if(number>1)
                {
                    number--;
                    mBookInCarts.get(i).setBookNumber(number);
                    break;
                }
                else if(number==1){
                    mBookInCarts.remove(i);
                    break;
                }
            }
        }
    }

    public static final void saveCartData(Context mContext){
        String data = JsonUtil.handleBookCartGsonToJsonString(mBookInCarts);

        SharedPreferences sharedPreferences = mContext.getSharedPreferences(CART_DATA, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(CART_DATA, data);
        editor.commit();
    }

    public static final void loadCartData(Context mContext){
        SharedPreferences pref = mContext.getSharedPreferences(CART_DATA,MODE_PRIVATE);
        String data = pref.getString(CART_DATA,"null");

        if(data.equals("null")==false){
            mBookInCarts = JsonUtil.handleStringDataToList(data);
        }
    }
}
