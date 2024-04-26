package com.file_uploadS3Bucket.file_uploadS3Bucket.repository;

import com.file_uploadS3Bucket.file_uploadS3Bucket.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
