package com.skully.skully.repository;

import com.skully.skully.model.Verification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VerificationRepository extends JpaRepository<Verification, Long> {
    Page<Verification> findByStatus(String status, Pageable pageable);
}
