package com.iprobe.product.model.entity;

import com.iprobe.product.model.dto.ProductDTO;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "products_berra")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "product_name")
    private String name;
    private double price;
    private String imageUrl;

    public ProductDTO toProductDTO(){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(this.getId());
        productDTO.setName(this.getName());
        productDTO.setImageUrl(this.getImageUrl());
        productDTO.setPrice(this.getPrice());
        return productDTO;
    }
}
