package com.skully.skully.controller;

import com.skully.skully.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;


    @PostMapping("/create-session")
    public ResponseEntity<?> createSession(@RequestBody Map<String, String> body) {
        Long orderId = body.get("orderId") == null ? null : Long.valueOf(body.get("orderId"));
        String amount = body.get("amount");
        return ResponseEntity.ok(paymentService.createSession(orderId, amount));
    }

    @PostMapping("/webhook")
    public ResponseEntity<?> webhook(@RequestBody Map<String, Object> body) {
        // provider webhook handling stub
        return ResponseEntity.ok().build();
    }
}
