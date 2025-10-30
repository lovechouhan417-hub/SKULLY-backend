package com.skully.skully.service;

import com.skully.skully.model.Listing;
import com.skully.skully.repository.ListingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ListingService {
    @Autowired
    private ListingRepository listingRepository;

    public ListingService(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    public Page<Listing> list(int page, int limit) {
        return listingRepository.findAll(PageRequest.of(page, limit));
    }

    public Listing get(Long id) {
        return listingRepository.findById(id).orElse(null);
    }

    public Listing create(Listing listing) {
        return listingRepository.save(listing);
    }

    public Listing update(Long id, Listing partial) {
        return null;
    }

    public void delete(Long id) {
        listingRepository.deleteById(id);
    }
}
