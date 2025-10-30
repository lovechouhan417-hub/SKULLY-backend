package com.skully.skully.controller;

import com.skully.skully.model.Upload;
import com.skully.skully.service.UploadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/uploads")
public class UploadController {
    

    @Autowired
    private UploadService uploadService;
    
    @PostMapping
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws IOException {
        Upload u = uploadService.store(file);
        return ResponseEntity.ok(Map.of("fileId", u.getId(), "url", u.getUrl(), "mimeType", u.getMimeType()));
    }

    @GetMapping("/{fileId}")
    public ResponseEntity<?> get(@PathVariable Long fileId) {
        Upload u = uploadService.find(fileId);
        if (u == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(u);
    }
}
