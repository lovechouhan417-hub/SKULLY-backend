package com.skully.skully.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentService {
    public Map<String, String> createSession(Long orderId, String amount) {
        // stub: return fake session id/url
        return Map.of("sessionId", "sess_" + System.currentTimeMillis(), "url",
                "https://payments.example/checkout/session");
    }
}
