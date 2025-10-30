package com.skully.skully.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/stats")
public class StatsController {
    @GetMapping("/usage")
    public ResponseEntity<?> usage() {
        // admin-only endpoint in real app. return small stub
        return ResponseEntity.ok(Map.of("users", 0, "listings", 0, "orders", 0));
    }
}
