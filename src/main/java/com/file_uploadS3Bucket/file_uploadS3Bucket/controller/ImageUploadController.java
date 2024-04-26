package com.file_uploadS3Bucket.file_uploadS3Bucket.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
@RestController
@RequestMapping("/api")
public class ImageUploadController {
    @Autowired
    private S3Client s3Client;

    @Value("${aws.bucketName}")
    private String bucketName;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            PutObjectRequest request = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(file.getOriginalFilename())
                    .build();
            s3Client.putObject(request, RequestBody.fromBytes(file.getBytes()));
            String objectUrl = s3Client.utilities().getUrl(builder -> builder.bucket(bucketName).key(file.getOriginalFilename())).toExternalForm();
            return ResponseEntity.ok("Imagem carregada com sucesso! URL: " + objectUrl);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Erro ao carregar a imagem");
        }
    }
}
