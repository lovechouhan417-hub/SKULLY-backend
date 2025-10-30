package com.skully.skully.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skully.skully.model.Upload;

public interface UploadRepository extends JpaRepository<Upload, Long> {
}
