package tech.panbin.shoppingcart;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import tech.panbin.shoppingcart.data.CartData;
import tech.panbin.shoppingcart.model.BookInCart;

import static tech.panbin.shoppingcart.data.CartData.CART_DATA_TAG;
import static tech.panbin.shoppingcart.data.CartData.DATA_LIST_TAG;
import static tech.panbin.shoppingcart.data.CartData.DATA_MAP_TAG;
import static tech.panbin.shoppingcart.data.CartData.DATA_SAVE_TAG;

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
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private boolean isSave;


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

    @Override
    protected void onStop() {
        super.onStop();
    }

//    private void saveCartData(){
//
//        if(!CartData.getBooksInCartList().equals("null")){
////           String data = JsonUtil.handleCartDataToJsonString(BOOKS_IN_CART_LIST);
//            Gson gson = new Gson();
//            String jsonMap = gson.toJson(CartData.getBooksInCarsMap());
//            String jsonList = gson.toJson(CartData.getBooksInCartList());
//
//            SharedPreferences sharedPreferences = getSharedPreferences(CART_DATA_TAG, Context.MODE_PRIVATE);
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putString(DATA_MAP_TAG,jsonMap);
//            editor.putString(DATA_LIST_TAG,jsonList);
//            editor.putBoolean(DATA_SAVE_TAG,true);
//            editor.apply();
//        }
//    }

//    private void loadCartData(){
//        SharedPreferences pref = getSharedPreferences(CART_DATA_TAG,MODE_PRIVATE);
//        String jsonMap = pref.getString(DATA_MAP_TAG,"null");
//        String jsonList = pref.getString(DATA_LIST_TAG,"null");
//        boolean isSaved = pref.getBoolean(DATA_SAVE_TAG,false);
//
//        if(isSaved==true){
//            Gson gson = new Gson();
//
//            Type collectionTypeMap = new TypeToken<HashMap<String,Integer>>(){}.getType();
//            HashMap<String,Integer> map = gson.fromJson(jsonMap, collectionTypeMap);
//            CartData.setBooksInCarsMap(map);
//
//            Type collectionTypeList = new TypeToken<ArrayList<BookInCart>>(){}.getType();
//            ArrayList<BookInCart> list = gson.fromJson(jsonList, collectionTypeList);
//            CartData.setBooksInCartList(list);
//        }
//    }
}
