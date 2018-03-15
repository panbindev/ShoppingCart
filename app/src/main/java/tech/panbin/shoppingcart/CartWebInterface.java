package tech.panbin.shoppingcart;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import java.util.Map;

import tech.panbin.shoppingcart.data.CartData;
import tech.panbin.shoppingcart.gson.BooksGsonBean;
import tech.panbin.shoppingcart.util.JsonUtil;

/**
 * Created by PanBin on 2018/03/15.
 */

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

        // TODO: 2018/03/15 addBookToCart在showToast前就看不见toast了，原因未知
        @JavascriptInterface
        public void addToCart(String bookJson){
//                Log.e("webJson",bookJson);
//                this.showToast("添加成功");
                BooksGsonBean booksGsonBean = JsonUtil.handleBookJsonToGson(bookJson);
                String message = "《" + booksGsonBean.getTitle() + "》"+"添加成功";
                Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
                CartData.addBookToCart(booksGsonBean);
        }

        @JavascriptInterface
        public void loadCartData(){
                String data = JsonUtil.handleBookCartGsonToString(CartData.mBookInCarts);
        }

}
