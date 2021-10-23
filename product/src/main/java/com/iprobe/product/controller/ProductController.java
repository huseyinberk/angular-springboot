package com.iprobe.product.controller;


import com.iprobe.product.model.dto.ProductDTO;
import com.iprobe.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductController {

    /*@RequestMapping(value = "/product" , method = RequestMethod.GET)
    public String getProduct(){
        return "Test";
    }*/
    /*@RequestMapping(value = "/product" , method = RequestMethod.GET)
    public ProductDTO getProduct(){
        ProductDTO p = new ProductDTO();
        p.setId(123);
        p.setName("ProductName");
        return p;
    }

    @RequestMapping(value = "/product2" , method = RequestMethod.GET)
    public ProductDTO getProduct2(String name){
        ProductDTO p = new ProductDTO();
        p.setId(345);
        p.setName(name);
        return p;
    }*/
    @Autowired //nesne istek geldikçe oluşur
    ProductService productService;

    @RequestMapping(value = "/product" , method = RequestMethod.GET)
    public List<ProductDTO> getProducts(){
        return productService.getProducts();
    }

    @RequestMapping(value = "/product/{id}" , method = RequestMethod.GET)
    public ProductDTO getProductById(@PathVariable long id) {
        return productService.getProduct(id);
    }

    @RequestMapping(value = "/product" , method = RequestMethod.POST)
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @RequestMapping(value = "/product" , method = RequestMethod.PUT)
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) { //json dan java objesi üretme - jackson
        return productService.updateProduct(productDTO);
    }

    @RequestMapping(value = "/product/{id}" , method = RequestMethod.DELETE)
    public ProductDTO deleteProduct(@PathVariable long id) {
        return productService.deleteProduct(id);
    }
}
