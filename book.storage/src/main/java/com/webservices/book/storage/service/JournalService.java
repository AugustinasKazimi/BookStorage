package com.webservices.book.storage.service;

import com.webservices.book.storage.entity.JournalStorageRequest;
import com.webservices.book.storage.entity.JournalStorageResponse;

public interface JournalService {
    JournalStorageResponse getJournal(String barcode);
    JournalStorageResponse putJournal(JournalStorageRequest journalDetails);
    int countJournalPrice(String barcode);
}
