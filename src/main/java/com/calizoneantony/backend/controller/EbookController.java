package com.calizoneantony.backend.controller;

import com.calizoneantony.backend.entity.Ebook;
import com.calizoneantony.backend.service.EbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ebook")
@CrossOrigin("${allowed.origins}")
public class EbookController {

    @Autowired
    EbookService ebookService;

    @GetMapping
    public ResponseEntity<List<Ebook>> getEbooks() {
        List<Ebook> ebookList = ebookService.getEbooks();
        return new ResponseEntity<>(ebookList, HttpStatus.OK);
    }
}
