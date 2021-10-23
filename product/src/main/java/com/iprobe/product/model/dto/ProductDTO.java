package com.iprobe.product.model.dto;

import com.iprobe.product.model.entity.Product;
import lombok.Data;  //create oen getters setters. Avoid spaggethi code.
@Data //The @Data annotation is likely the most frequently used annotation
      // in the Project Lombok toolset. It combines the functionality of @ToString, @EqualsAndHashCode, @Getter, and @Setter.
public class ProductDTO {
    private long id;
    private String name;
    private double price;
    private String imageUrl;

    public Product toProduct(){
        Product product = new Product();
        product.setId(this.getId());
        product.setName(this.getName());
        product.setImageUrl(this.getImageUrl());
        product.setPrice(this.getPrice());
        return product;
    }
}
