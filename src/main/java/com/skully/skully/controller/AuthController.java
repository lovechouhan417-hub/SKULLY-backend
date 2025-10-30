package com.skully.skully.controller;

import com.skully.skully.dto.RegisterRequest;
import com.skully.skully.model.User;
import com.skully.skully.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) { this.authService = authService; }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        User created = authService.register(req);
        if (created == null) return ResponseEntity.badRequest().body("Email already used");
        return ResponseEntity.ok(created);
    }
}