package com.skully.skully.controller;

import com.skully.skully.service.NotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;


    @GetMapping
    public ResponseEntity<?> list(@RequestParam(required = false) Long userId,
            @RequestParam(required = false) Boolean unreadOnly) {
        // stub: would query notifications table
        return ResponseEntity.ok(java.util.List.of());
    }

    @PostMapping("/send")
    public ResponseEntity<?> send(@RequestBody java.util.Map<String, Object> body) {
        Long userId = body.get("userId") == null ? null : Long.valueOf(body.get("userId").toString());
        String type = (String) body.get("type");
        String payload = body.get("payload") == null ? "" : body.get("payload").toString();
        notificationService.sendInternalNotification(userId, type, payload);
        return ResponseEntity.ok().build();
    }
}
