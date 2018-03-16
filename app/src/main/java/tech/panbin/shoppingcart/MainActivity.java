package tech.panbin.shoppingcart;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import tech.panbin.shoppingcart.data.CartData;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_list:
                    myWebView.loadUrl("file:///android_asset/www/list.html");
                    return true;
                case R.id.navigation_cart:
                    myWebView.loadUrl("file:///android_asset/www/cart.html");
                    return true;
            }
            return false;
        }
    };

    private WebView myWebView;
    private WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CartData.loadCartData(this);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        myWebView = findViewById(R.id.webview_container);
        webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.addJavascriptInterface(new CartWebInterface(this), "Android");
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("file:///android_asset/www/list.html");
    }

    @Override
    protected void onPause() {
        CartData.saveCartData(this);
        super.onPause();
    }
}
