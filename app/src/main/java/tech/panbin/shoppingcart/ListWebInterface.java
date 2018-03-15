package tech.panbin.shoppingcart;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by PanBin on 2018/03/15.
 */

public class ListWebInterface {

        Context mContext;

        /** Instantiate the interface and set the context */
        ListWebInterface(Context c) {
            mContext = c;
        }

        /** Show a toast from the web page */
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }

}
