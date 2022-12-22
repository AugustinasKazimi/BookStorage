package com.webservices.book.storage.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BookStorageRequest {

    @NotNull
    private String bookName;
    @NotNull
    private String bookAuthor;
    @NotNull @Size(min=8, max=8)
    private String barcode;
    @NotNull
    private int bookQuantity;
    @NotNull
    private int bookPrice;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }
}
