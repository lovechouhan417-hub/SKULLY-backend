package com.skully.skully.controller;

import com.skully.skully.model.Listing;
import com.skully.skully.model.OrderEntity;
import com.skully.skully.service.FarmerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/farmers")
public class FarmerController {
    @Autowired
    private FarmerService farmerService;

   

    @GetMapping("/{id}/dashboard")
    public ResponseEntity<?> dashboard(@PathVariable Long id) {
        // simple summary
        var listings = farmerService.listingsFor(id);
        var orders = farmerService.ordersForFarmer(id);
        java.util.Map<String, Object> result = new java.util.HashMap<>();
        result.put("profile", null);
        result.put("stats", null);
        result.put("recentListings", listings);
        result.put("relatedOrders", orders);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}/listings")
    public ResponseEntity<List<Listing>> listings(@PathVariable Long id) {
        return ResponseEntity.ok(farmerService.listingsFor(id));
    }

    @GetMapping("/{id}/orders")
    public ResponseEntity<List<OrderEntity>> orders(@PathVariable Long id) {
        return ResponseEntity.ok(farmerService.ordersForFarmer(id));
    }
}
