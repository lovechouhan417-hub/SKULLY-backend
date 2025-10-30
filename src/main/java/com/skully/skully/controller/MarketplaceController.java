package com.skully.skully.controller;

import com.skully.skully.model.Listing;
import com.skully.skully.model.OrderEntity;
import com.skully.skully.service.ListingService;
import com.skully.skully.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;

@RestController
@RequestMapping("/api/marketplace")
public class MarketplaceController {

    @Autowired
    private ListingService listingService;

    @Autowired
    private OrderService orderService;

    // Listings
    @GetMapping("/listings")
    public ResponseEntity<?> listListings(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int limit) {
        Page<Listing> p = listingService.list(page, limit);
        return ResponseEntity.ok(p);
    }

    @GetMapping("/listings/{id}")
    public ResponseEntity<?> getListing(@PathVariable Long id) {
        Listing l = listingService.get(id);
        if (l == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(l);
    }

    @PostMapping("/listings")
    public ResponseEntity<?> createListing(@RequestBody Listing listing) {
        Listing created = listingService.create(listing);
        return ResponseEntity.created(URI.create("/api/marketplace/listings/" + created.getId())).body(created);
    }

    @PutMapping("/listings/{id}")
    public ResponseEntity<?> updateListing(@PathVariable Long id, @RequestBody Listing listing) {
        Listing updated = listingService.update(id, listing);
        if (updated == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/listings/{id}")
    public ResponseEntity<?> deleteListing(@PathVariable Long id) {
        listingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Orders
    @PostMapping("/orders")
    public ResponseEntity<?> placeOrder(@RequestBody OrderEntity order) {
        OrderEntity o = orderService.create(order);
        return ResponseEntity.ok(o);
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<?> getOrder(@PathVariable Long orderId) {
        OrderEntity o = orderService.get(orderId);
        if (o == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(o);
    }

    @GetMapping("/orders")
    public ResponseEntity<?> listOrders(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int limit) {
        return ResponseEntity.ok(orderService.list(page, limit));
    }
}
