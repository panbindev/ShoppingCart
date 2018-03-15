package tech.panbin.shoppingcart;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import java.util.Map;

/**
 * Created by PanBin on 2018/03/15.
 */

public class CartWebInterface {

        Context mContext;

        private String bookId;

        private int bookNumber;

        public static Map<String,Integer> BOOKS_CART_MAP;



        /** Instantiate the interface and set the context */
        CartWebInterface(Context c) {
            mContext = c;
        }

        /** Show a toast from the web page */
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }

}
