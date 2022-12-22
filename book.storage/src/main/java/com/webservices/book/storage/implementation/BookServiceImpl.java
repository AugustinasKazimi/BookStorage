package com.webservices.book.storage.implementation;

import com.webservices.book.storage.entity.BookStorageRequest;
import com.webservices.book.storage.entity.BookStorageResponse;
import com.webservices.book.storage.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    Map<String, BookStorageResponse> books;

    @Override
    public BookStorageResponse putBook(BookStorageRequest bookDetails) {

        BookStorageResponse book = new BookStorageResponse();
        book.setBookName(bookDetails.getBookName());
        book.setBookAuthor(bookDetails.getBookAuthor());
        book.setBarcode(bookDetails.getBarcode());
        book.setBookPrice(bookDetails.getBookPrice());
        book.setBookQuantity(bookDetails.getBookQuantity());

        if (books == null) {
            books = new HashMap<>();
        }
        books.put(bookDetails.getBarcode(), book);

        return book;
    }

    @Override
    public BookStorageResponse getBook(String barcode) {
        if (books.containsKey(barcode)) {
            return books.get(barcode);
        } else {
            return new ResponseEntity<BookStorageResponse>(HttpStatus.NO_CONTENT).getBody();
        }
    }

    @Override
    public BookStorageResponse updateBook(String barcode, BookStorageRequest bookDetails) {

        BookStorageResponse storedBookDetails = books.get(barcode);
        storedBookDetails.setBookName(bookDetails.getBookName());
        storedBookDetails.setBookAuthor(bookDetails.getBookAuthor());
        storedBookDetails.setBarcode(bookDetails.getBarcode());
        storedBookDetails.setBookPrice(bookDetails.getBookPrice());
        storedBookDetails.setBookQuantity(bookDetails.getBookQuantity());

        books.put(barcode, storedBookDetails);

        return storedBookDetails;
    }

    @Override
    public int countBookPrice(String barcode) {
        if (books.containsKey(barcode)) {

            BookStorageResponse bookTotalPrice = books.get(barcode);
            return (bookTotalPrice.getBookPrice() * bookTotalPrice.getBookQuantity());
        } else {
            return (int) new ResponseEntity<>(HttpStatus.NO_CONTENT).getBody();
        }
    }

    @Override
    public List<BookStorageResponse> getBookByQuantity(int bookQuantity) {

        List<BookStorageResponse> bookList = new ArrayList<>();

            if(books.containsKey(bookQuantity)) {
                BookStorageResponse allBooks = books.get(bookQuantity);
                allBooks.getBarcode();
                bookList.add(allBooks);
                return bookList;
            }
        else{
            return null;
            }
    }
}
