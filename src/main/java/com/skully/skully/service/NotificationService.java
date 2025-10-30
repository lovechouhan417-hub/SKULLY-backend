package com.skully.skully.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void sendInternalNotification(Long userId, String type, String payload) {
        // stub: in real system we'd push to queue/email/push service
        System.out.println("Notify user=" + userId + " type=" + type + " payload=" + payload);
    }
}
