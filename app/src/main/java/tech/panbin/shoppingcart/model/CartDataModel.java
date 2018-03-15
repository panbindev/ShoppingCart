package tech.panbin.shoppingcart.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PanBin on 2018/03/15.
 */

public class CartDataModel {
    private List<BookInCart> mBookInCarts;

    CartDataModel() {
        this.mBookInCarts = new ArrayList<>();
    }

    public List<BookInCart> getBookInCarts() {
        return mBookInCarts;
    }

    public void setBookInCarts(List<BookInCart> mBookInCarts) {
        this.mBookInCarts = mBookInCarts;
    }
}
