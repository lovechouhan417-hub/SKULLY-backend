package com.skully.skully.service;

import com.skully.skully.model.Listing;
import com.skully.skully.model.OrderEntity;
import com.skully.skully.repository.ListingRepository;
import com.skully.skully.repository.OrderRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class FarmerService {



    @Autowired
    private ListingRepository listingRepository;
    @Autowired
    private OrderRepository orderRepository;

  

    public List<Listing> listingsFor(Long farmerId) {
        return listingRepository.findBySellerId(farmerId, PageRequest.of(0, 100)).getContent();
    }

    public List<OrderEntity> ordersForFarmer(Long farmerId) {
        // simple approach: return orders where the listing belongs to farmer - naive
        // for prototype
        return orderRepository.findAll().stream().filter(o -> {
            var listing = listingRepository.findById(o.getListingId()).orElse(null);
            return listing != null && listing.getSellerId() != null && listing.getSellerId().equals(farmerId);
        }).toList();
    }
}
