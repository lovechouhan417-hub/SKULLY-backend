package com.skully.skully.repository;

import com.skully.skully.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ListingRepository extends JpaRepository<Listing, Long> {
    Page<Listing> findByCategoryContainingIgnoreCase(String category, Pageable pageable);

    Page<Listing> findBySellerId(Long sellerId, Pageable pageable);
}
