package com.skully.skully.repository;

import com.skully.skully.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    Page<OrderEntity> findByBuyerId(Long buyerId, Pageable pageable);

    Page<OrderEntity> findByStatus(String status, Pageable pageable);
}
