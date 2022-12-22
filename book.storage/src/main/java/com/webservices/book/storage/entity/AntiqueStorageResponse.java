package com.webservices.book.storage.entity;

public class AntiqueStorageResponse {
    private String antiqueName;
    private String antiqueAuthor;
    private String barcode;
    private int antiqueQuantity;
    private int antiquePrice;
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
