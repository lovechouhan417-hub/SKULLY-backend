package com.skully.skully.service;

import com.skully.skully.model.Verification;
import com.skully.skully.repository.UserRepository;
import com.skully.skully.repository.VerificationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationRepository verificationRepository;


    public Page<Verification> listVerifications(String status, int page, int limit) {
        if (status == null)
            return verificationRepository.findAll(PageRequest.of(page, limit));
        return verificationRepository.findByStatus(status, PageRequest.of(page, limit));
    }

    public Verification approve(Long id) {
        return verificationRepository.findById(id).map(v -> {
            v.setStatus("approved");
            return verificationRepository.save(v);
        }).orElse(null);
    }

    public Verification reject(Long id, String reason) {
        return verificationRepository.findById(id).map(v -> {
            v.setStatus("rejected");
            v.setReason(reason);
            return verificationRepository.save(v);
        }).orElse(null);
    }
}
