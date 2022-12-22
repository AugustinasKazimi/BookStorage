package com.webservices.book.storage.service;

import com.webservices.book.storage.entity.AntiqueStorageRequest;
import com.webservices.book.storage.entity.AntiqueStorageResponse;

public interface AntiqueService {
    AntiqueStorageResponse getAntique(String barcode);
    AntiqueStorageResponse putAntique(AntiqueStorageRequest antiqueDetails);
    int countAntiquePrice(String barcode);
}
