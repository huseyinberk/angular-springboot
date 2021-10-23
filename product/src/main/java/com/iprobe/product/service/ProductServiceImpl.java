package com.iprobe.product.service;

import com.iprobe.product.model.dto.ProductDTO;
import com.iprobe.product.model.entity.Product;
import com.iprobe.product.repository.ProductRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductDTO> getProducts() {
        return productRepository.findAll().stream().map(Product::toProductDTO).collect(Collectors.toList());

    }

    @Override
    public ProductDTO getProduct(long id) {
        /*ProductDTO p = productRepository.findById(id).get().toProductDTO();
        return p;*/
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            ProductDTO productDTO = productRepository.findById(id).get().toProductDTO();
            return productDTO;
        }else{
            throw new RuntimeException();
        }
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
       Product product= productRepository.save(productDTO.toProduct());
       return product.toProductDTO() ;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        /*Product p = productRepository.getById(productDTO.getId());
        p.setId(productDTO.getId());
        p.setImageUrl(productDTO.getImageUrl());
        p.setPrice(productDTO.getPrice());
        p.setName(productDTO.getName());
        productRepository.save(p);*/
        Product p = productDTO.toProduct();
        productRepository.save(p);
        return p.toProductDTO();

    }

    @Override
    public ProductDTO deleteProduct(long id) {
        Optional<Product> p = productRepository.findById(id);
        if(p.isPresent()){
            productRepository.delete(p.get());
            return p.get().toProductDTO();
        }else{
            throw new RuntimeException();
        }
    }
}
