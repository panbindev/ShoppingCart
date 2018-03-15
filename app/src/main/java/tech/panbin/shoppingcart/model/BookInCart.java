package tech.panbin.shoppingcart.model;

import tech.panbin.shoppingcart.gson.BooksGsonBean;

/**
 * Created by PanBin on 2018/03/15.
 */

public class BookInCart extends BooksGsonBean {
    private int bookNumber;

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int mBookNumber) {
        bookNumber = mBookNumber;
    }
}
