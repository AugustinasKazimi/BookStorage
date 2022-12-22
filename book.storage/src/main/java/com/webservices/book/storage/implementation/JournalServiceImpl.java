package com.webservices.book.storage.implementation;


import com.webservices.book.storage.entity.JournalStorageRequest;
import com.webservices.book.storage.entity.JournalStorageResponse;
import com.webservices.book.storage.service.JournalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class JournalServiceImpl implements JournalService {

    Map<String, JournalStorageResponse> journals;

    @Override
    public JournalStorageResponse getJournal(String barcode) {
        if (journals.containsKey(barcode)) {
            return journals.get(barcode);
        } else {
            return new ResponseEntity<JournalStorageResponse>(HttpStatus.NO_CONTENT).getBody();
        }
    }

    @Override
    public JournalStorageResponse putJournal(JournalStorageRequest journalDetails) {
        JournalStorageResponse journal = new JournalStorageResponse();
        journal.setJournalName(journalDetails.getJournalName());
        journal.setJournalAuthor(journalDetails.getJournalAuthor());
        journal.setBarcode(journalDetails.getBarcode());
        journal.setJournalPrice(journalDetails.getJournalPrice());
        journal.setJournalQuantity(journalDetails.getJournalQuantity());
        journal.setScienceIndex(journalDetails.getScienceIndex());

        if (journals == null) {
            journals = new HashMap<>();
        }
        journals.put(journalDetails.getBarcode(), journal);

        return journal;
    }

    @Override
    public int countJournalPrice(String barcode) {

        if (journals.containsKey(barcode)) {

            JournalStorageResponse journalTotalPrice = journals.get(barcode);

            return (journalTotalPrice.getJournalPrice() * journalTotalPrice.getJournalQuantity() * journalTotalPrice.getScienceIndex());
        } else {
            return (int) new ResponseEntity<>(HttpStatus.NO_CONTENT).getBody();
        }
    }
}
