package com.webservices.book.storage.controller;

import com.webservices.book.storage.entity.AntiqueStorageRequest;
import com.webservices.book.storage.entity.AntiqueStorageResponse;
import com.webservices.book.storage.service.AntiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("antique")
public class AntiqueController {
    Map<String, AntiqueStorageResponse> antiques;
    @Autowired
    AntiqueService antiqueService;

    @GetMapping(path = "/{barcode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AntiqueStorageResponse> getAntique(@PathVariable String barcode) {

        AntiqueStorageResponse antique = antiqueService.getAntique(barcode);
        return new ResponseEntity<>(antique,HttpStatus.FOUND);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AntiqueStorageResponse> putAntique(@Valid @RequestBody AntiqueStorageRequest antiqueDetails) {

        AntiqueStorageResponse antique = antiqueService.putAntique(antiqueDetails);
        return new ResponseEntity<>(antique, HttpStatus.FOUND);
    }

    @GetMapping(path = "/price/{barcode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> countAntiquePrice(@PathVariable String barcode) {

        int antique = antiqueService.countAntiquePrice(barcode);
        return new ResponseEntity<>(antique, HttpStatus.FOUND);
    }
}
