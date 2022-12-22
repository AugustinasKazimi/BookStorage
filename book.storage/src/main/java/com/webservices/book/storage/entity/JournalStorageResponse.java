package com.webservices.book.storage.entity;

public class JournalStorageResponse {
    private String journalName;
    private String journalAuthor;
    private String barcode;
    private int journalQuantity;
    private int journalPrice;
    private int scienceIndex;

    public String getJournalName() {
        return journalName;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
    }

    public String getJournalAuthor() {
        return journalAuthor;
    }

    public void setJournalAuthor(String journalAuthor) {
        this.journalAuthor = journalAuthor;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getJournalQuantity() {
        return journalQuantity;
    }

    public void setJournalQuantity(int journalQuantity) {
        this.journalQuantity = journalQuantity;
    }

    public int getJournalPrice() {
        return journalPrice;
    }

    public void setJournalPrice(int journalPrice) {
        this.journalPrice = journalPrice;
    }

    public int getScienceIndex() {
        return scienceIndex;
    }

    public void setScienceIndex(int scienceIndex) {
        this.scienceIndex = scienceIndex;
    }
}
