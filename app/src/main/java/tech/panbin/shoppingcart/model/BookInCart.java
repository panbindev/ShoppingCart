package tech.panbin.shoppingcart.model;

import tech.panbin.shoppingcart.gson.BooksGsonBean;

/**
 * Created by PanBin on 2018/03/15.
 */

public class BookInCart {

    private String id;

    private String title;

    private String price;

    private String coverPictureUrl;

    private int bookNumber;//want to buy

    public BookInCart(BooksGsonBean mGsonBean,int number) {
        this.id = mGsonBean.getId();
        this.title = mGsonBean.getTitle();
        this.price = mGsonBean.getPrice();
        this.coverPictureUrl = mGsonBean.getImages().getSmall();
        this.bookNumber = number;
    }

    /*购物车内数量0无意义，至少为1*/
    public BookInCart(BooksGsonBean mGsonBean) {
        new BookInCart(mGsonBean,1);
    }

    public String getId() {
        return id;
    }

    public void setId(String mId) {
        id = mId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String mTitle) {
        title = mTitle;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String mPrice) {
        price = mPrice;
    }

    public String getCoverPictureUrl() {
        return coverPictureUrl;
    }

    public void setCoverPictureUrl(String mCoverPictureUrl) {
        coverPictureUrl = mCoverPictureUrl;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int mBookNumber) {
        bookNumber = mBookNumber;
    }

    /*默认加一本*/
    public void addBookNumber(){
        addBookNumber(1);
    }
    /*添加到购物车*/
    public void addBookNumber(int n){
        this.bookNumber = bookNumber+n;
    }
}
