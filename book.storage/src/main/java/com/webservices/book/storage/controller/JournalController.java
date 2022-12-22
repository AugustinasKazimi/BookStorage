package com.webservices.book.storage.controller;

import com.webservices.book.storage.entity.JournalStorageRequest;
import com.webservices.book.storage.entity.JournalStorageResponse;
import com.webservices.book.storage.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("journal")
public class JournalController {
    Map<String, JournalStorageResponse> journals;
    @Autowired
    JournalService journalService;

    @GetMapping(path = "/{barcode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JournalStorageResponse> getJournal(@PathVariable String barcode) {

        JournalStorageResponse journal = journalService.getJournal(barcode);
        return new ResponseEntity<>(journal,HttpStatus.FOUND);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JournalStorageResponse> putJournal(@Valid @RequestBody JournalStorageRequest journalDetails) {

        JournalStorageResponse journal = journalService.putJournal(journalDetails);
        return new ResponseEntity<>(journal, HttpStatus.FOUND);
    }

    @GetMapping(path = "/price/{barcode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> countJournalPrice(@PathVariable String barcode) {

        int journal = journalService.countJournalPrice(barcode);
        return new ResponseEntity<>(journal, HttpStatus.FOUND);
    }
}
