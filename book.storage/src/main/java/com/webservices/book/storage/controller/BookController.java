package com.webservices.book.storage.controller;

import com.webservices.book.storage.entity.BookStorageRequest;
import com.webservices.book.storage.entity.BookStorageResponse;
import com.webservices.book.storage.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Book;
import java.util.*;

@RestController
@RequestMapping("book")
public class BookController {

    Map<String, BookStorageResponse> books;

    @Autowired
    BookService bookService;

    @GetMapping(path = "/{barcode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookStorageResponse> getBook(@PathVariable String barcode) {

    BookStorageResponse book = bookService.getBook(barcode);
    return new ResponseEntity<>(book, HttpStatus.FOUND);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookStorageResponse> putBook(@Valid @RequestBody BookStorageRequest bookDetails) {

        BookStorageResponse book = bookService.putBook(bookDetails);
        return new ResponseEntity<BookStorageResponse>(book, HttpStatus.FOUND);
    }

    @PutMapping(path = "/{barcode}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookStorageResponse> updateBook(@PathVariable String barcode, @RequestBody BookStorageRequest bookDetails) {

        BookStorageResponse book = bookService.updateBook(barcode, bookDetails);
        return new ResponseEntity<BookStorageResponse>(book, HttpStatus.FOUND);
    }

    @GetMapping(path = "/price/{barcode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> countBookPrice(@PathVariable String barcode) {

        int book = bookService.countBookPrice(barcode);
        return new ResponseEntity<>(book, HttpStatus.FOUND);
    }

    @GetMapping(path = "/sortedBooks/{bookQuantity}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookStorageResponse> sortedBook(@PathVariable int bookQuantity) {

        List<BookStorageResponse> allBooks = bookService.getBookByQuantity(bookQuantity);
        return allBooks;
    }
}
