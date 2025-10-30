package com.skully.skully.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skully.skully.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
