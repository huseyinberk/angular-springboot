package com.iprobe.product.service;

import com.iprobe.product.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getProducts();
    ProductDTO getProduct(long id);
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(ProductDTO productDTO);
    ProductDTO deleteProduct(long id);
}
