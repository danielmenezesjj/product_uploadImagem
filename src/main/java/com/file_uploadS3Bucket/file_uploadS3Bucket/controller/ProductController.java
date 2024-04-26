package com.file_uploadS3Bucket.file_uploadS3Bucket.controller;

import com.file_uploadS3Bucket.file_uploadS3Bucket.domain.Product;
import com.file_uploadS3Bucket.file_uploadS3Bucket.dto.ProductDTO;
import com.file_uploadS3Bucket.file_uploadS3Bucket.services.ProductService;
import com.file_uploadS3Bucket.file_uploadS3Bucket.services.S3BucketAwsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService service;


    @GetMapping
    public ResponseEntity<List<Product>> gettAll(){
        List<Product> produtos = service.getAll();
        return ResponseEntity.ok().body(produtos);
    }


    @PostMapping
    public ResponseEntity post (@ModelAttribute ProductDTO productData, @RequestParam("file") MultipartFile file){
        Product product = service.create(productData, file);
        return ResponseEntity.ok().body(product);
    }

}
