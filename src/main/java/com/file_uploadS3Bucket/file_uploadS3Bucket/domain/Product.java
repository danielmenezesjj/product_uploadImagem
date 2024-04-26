package com.file_uploadS3Bucket.file_uploadS3Bucket.domain;


import com.file_uploadS3Bucket.file_uploadS3Bucket.dto.ProductDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private Integer id;
    private String nmproduto;
    private String imagem;
    private Integer quantidade;


    public Product(ProductDTO product){
        this.nmproduto = product.nmproduto();
        this.imagem = product.imagem();
        this.quantidade = product.quantidade();
    }

}
