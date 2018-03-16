package tech.panbin.shoppingcart.model;

import tech.panbin.shoppingcart.gson.BooksGsonBean;

/**
 * Created by PanBin on 2018/03/15.
 */

/*购物车列表项*/
public class BookInCart {

    /*图书Id，唯一*/
    private String id;

    /*书名*/
    private String title;

    /*定价*/
    private String price;

    /*封面图片*/
    private String coverPictureUrl;

    /*购买数量*/
    private int bookNumber;//want to buy

    /*从Gson对象中构造实例时使用该方法。购物车内数量0无意义，故默认为1。*/
    public BookInCart(BooksGsonBean mGsonBean) {
        this.id = mGsonBean.getId();
        this.title = mGsonBean.getTitle();
        this.price = mGsonBean.getPrice();
        this.coverPictureUrl = mGsonBean.getImages().getSmall();
        this.bookNumber = 1;
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

}
