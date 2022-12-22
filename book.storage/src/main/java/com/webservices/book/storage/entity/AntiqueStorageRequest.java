package com.webservices.book.storage.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AntiqueStorageRequest {
    @NotNull
    private String antiqueName;
    @NotNull
    private String antiqueAuthor;
    @NotNull @Size(min=8, max=8)
    private String barcode;
    @NotNull
    private int antiqueQuantity;
    @NotNull
    private int antiquePrice;
    @Size(min=1900, max=2022)
    private int releaseYear;

    public String getAntiqueName() {
        return antiqueName;
    }

    public void setAntiqueName(String antiqueName) {
        this.antiqueName = antiqueName;
    }

    public String getAntiqueAuthor() {
        return antiqueAuthor;
    }

    public void setAntiqueAuthor(String antiqueAuthor) {
        this.antiqueAuthor = antiqueAuthor;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getAntiqueQuantity() {
        return antiqueQuantity;
    }

    public void setAntiqueQuantity(int antiqueQuantity) {
        this.antiqueQuantity = antiqueQuantity;
    }

    public int getAntiquePrice() {
        return antiquePrice;
    }

    public void setAntiquePrice(int antiquePrice) {
        this.antiquePrice = antiquePrice;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
