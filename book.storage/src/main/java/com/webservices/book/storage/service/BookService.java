package com.webservices.book.storage.service;

import com.webservices.book.storage.entity.BookStorageRequest;
import com.webservices.book.storage.entity.BookStorageResponse;

import java.util.List;

public interface BookService {
    BookStorageResponse putBook(BookStorageRequest bookDetails);
    BookStorageResponse getBook(String barcode);
    BookStorageResponse updateBook(String barcode, BookStorageRequest bookDetails);
    int countBookPrice(String barcode);
    List<BookStorageResponse> getBookByQuantity(int bookQuantity);
}
