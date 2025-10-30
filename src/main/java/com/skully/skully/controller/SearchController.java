package com.skully.skully.controller;

import com.skully.skully.service.SearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/search")
public class SearchController {
    @Autowired
    private SearchService searchService;


    @GetMapping
    public ResponseEntity<?> search(@RequestParam(required = false) String q,
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int limit) {
        return ResponseEntity.ok(searchService.searchListings(q, page, limit));
    }
}
