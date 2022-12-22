package com.webservices.book.storage.implementation;

import com.webservices.book.storage.entity.AntiqueStorageRequest;
import com.webservices.book.storage.entity.AntiqueStorageResponse;
import com.webservices.book.storage.service.AntiqueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.Year;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Service
public class AntiqueServiceImpl implements AntiqueService {

    Map<String, AntiqueStorageResponse> antiques;

    @Override
    public AntiqueStorageResponse getAntique(String barcode) {
        if (antiques.containsKey(barcode)) {
            return (antiques.get(barcode));
        } else {
            return new ResponseEntity<AntiqueStorageResponse>(HttpStatus.NO_CONTENT).getBody();
        }
    }

    @Override
    public AntiqueStorageResponse putAntique(AntiqueStorageRequest antiqueDetails) {

        AntiqueStorageResponse antique = new AntiqueStorageResponse();
        antique.setAntiqueName(antiqueDetails.getAntiqueName());
        antique.setAntiqueAuthor(antiqueDetails.getAntiqueAuthor());
        antique.setBarcode(antiqueDetails.getBarcode());
        antique.setAntiquePrice(antiqueDetails.getAntiquePrice());
        antique.setAntiqueQuantity(antiqueDetails.getAntiqueQuantity());
        antique.setReleaseYear(antiqueDetails.getReleaseYear());

        if (antiques == null) {
            antiques = new HashMap<>();
        }
        antiques.put(antiqueDetails.getBarcode(), antique);

        return antique;
    }

    @Override
    public int countAntiquePrice(String barcode) {

        if (antiques.containsKey(barcode)) {

            AntiqueStorageResponse antiqueTotalPrice = antiques.get(barcode);
            int currentYear = 2022;

            return (antiqueTotalPrice.getAntiquePrice() * antiqueTotalPrice.getAntiqueQuantity() * (currentYear - antiqueTotalPrice.getReleaseYear()));
        } else {
            return (int) new ResponseEntity<>(HttpStatus.NO_CONTENT).getBody();
        }
    }
}
