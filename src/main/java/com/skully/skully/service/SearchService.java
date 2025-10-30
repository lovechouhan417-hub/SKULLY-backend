package com.skully.skully.service;

import com.skully.skully.model.Listing;
import com.skully.skully.repository.ListingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    @Autowired
    private ListingRepository listingRepository;

    public Page<Listing> searchListings(String q, int page, int limit) {
        // very naive search: by category fallback to findAll
        if (q == null || q.isBlank())
            return listingRepository.findAll(PageRequest.of(page, limit));
        return listingRepository.findByCategoryContainingIgnoreCase(q, PageRequest.of(page, limit));
    }
}
