package com.skully.skully.controller;

import com.skully.skully.model.Verification;
import com.skully.skully.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/verifications")
    public ResponseEntity<Page<Verification>> listVerifications(@RequestParam(required = false) String status,
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int limit) {
        return ResponseEntity.ok(adminService.listVerifications(status, page, limit));
    }

    @PutMapping("/verifications/{id}/approve")
    public ResponseEntity<?> approve(@PathVariable Long id) {
        Verification v = adminService.approve(id);
        if (v == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(v);
    }

    @PutMapping("/verifications/{id}/reject")
    public ResponseEntity<?> reject(@PathVariable Long id,
            @RequestBody(required = false) java.util.Map<String, String> body) {
        String reason = body != null ? body.get("reason") : null;
        Verification v = adminService.reject(id, reason);
        if (v == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(v);
    }
}
