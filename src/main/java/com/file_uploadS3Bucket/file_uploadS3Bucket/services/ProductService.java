package com.file_uploadS3Bucket.file_uploadS3Bucket.services;


import com.file_uploadS3Bucket.file_uploadS3Bucket.domain.Product;
import com.file_uploadS3Bucket.file_uploadS3Bucket.dto.ProductDTO;
import com.file_uploadS3Bucket.file_uploadS3Bucket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProductService {


    @Autowired
    private ProductRepository repository;

    @Autowired
    private S3BucketAwsService s3Bucket;

    public Product create (ProductDTO productData, MultipartFile file){
        Product product = new Product(productData);
       var uploadImagem = s3Bucket.uploadImage(file);
       product.setImagem(uploadImagem);
        repository.save(product);
        return product;
    }

    public List<Product> getAll(){
        return repository.findAll();
    }

}
