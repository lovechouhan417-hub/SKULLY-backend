package com.skully.skully.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.skully.skully.model.Upload;
import com.skully.skully.repository.UploadRepository;

@Service
public class UploadService {

    @Autowired
    private UploadRepository uploadRepository;


    public Upload store(MultipartFile file) throws IOException {
        // In a real app you'd save to cloud or file store. Here we keep minimal
        // metadata.
        Upload u = new Upload();
        u.setFileName(file.getOriginalFilename());
        u.setMimeType(file.getContentType());
        // for prototype, build a pseudo-url
        u.setUrl("/uploads/" + System.currentTimeMillis() + "_" + file.getOriginalFilename());
        return uploadRepository.save(u);
    }

    public Upload find(Long id) {
        return uploadRepository.findById(id).orElse(null);
    }
}
