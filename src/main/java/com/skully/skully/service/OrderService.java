package com.skully.skully.service;

import com.skully.skully.model.OrderEntity;
import com.skully.skully.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public OrderEntity create(OrderEntity order) {
        order.setStatus(order.getStatus() == null ? "pending" : order.getStatus());
        return orderRepository.save(order);
    }

    public OrderEntity get(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Page<OrderEntity> list(int page, int limit) {
        return orderRepository.findAll(PageRequest.of(page, limit));
    }
}
