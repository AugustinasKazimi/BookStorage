package com.webservices.book.storage.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class JournalStorageRequest {
    @NotNull
    private String journalName;
    @NotNull
    private String journalAuthor;
    @NotNull @Size(min=8, max=8)
    private String barcode;
    @NotNull
    private int journalQuantity;
    @NotNull
    private int journalPrice;
    @Size(min=1,max=10)
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
