package com.webservices.book.storage;

import com.webservices.book.storage.controller.BookController;
import com.webservices.book.storage.entity.BookStorageResponse;
import com.webservices.book.storage.implementation.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BookControllerTest {

    @InjectMocks
    BookController bookController;

    @Mock
    BookServiceImpl bookService;

    BookStorageResponse bookStorageResponse;

    final String barcode = "12345678";

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.openMocks(this);

        bookStorageResponse = new BookStorageResponse();
        bookStorageResponse.setBookAuthor("Augustinas");
        bookStorageResponse.setBookName("Testing");
        bookStorageResponse.setBarcode(barcode);
        bookStorageResponse.setBookPrice(5);
        bookStorageResponse.setBookQuantity(5);
    }

    @Test
    final void testGetBook(){
        when(bookService.getBook(anyString())).thenReturn(bookStorageResponse);

        BookStorageResponse book = bookService.getBook(barcode);

        assertNotNull(book);
        assertEquals(barcode, book.getBarcode());
        assertEquals(bookStorageResponse.getBookName(), book.getBookName());
        assertEquals(bookStorageResponse.getBookAuthor(), book.getBookAuthor());
        assertEquals(bookStorageResponse.getBookPrice(), book.getBookPrice());
        assertEquals(bookStorageResponse.getBookQuantity(), book.getBookQuantity());
    }
}
