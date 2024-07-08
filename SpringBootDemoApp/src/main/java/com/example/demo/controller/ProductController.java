package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @RequestMapping("/")
    public String welcome()
    {
        return "Welcome to SpringBoot";
    }

    @GetMapping("/products")
    public List<Product> getAll()
    {
        return productService.allProducts();
    }

    @GetMapping("/products/{productId}")
    public Product getSingleById(@PathVariable int productId)
    {
        return productService.singleProduct(productId);
    }

    @PostMapping("/product")
    public void addProducts(@RequestBody Product product)
    {
        productService.addProduct(product);
    }

    @PutMapping("/product")
    public void updateProduct(@RequestBody Product product)
    {
        productService.updateProduct(product);
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable int productId)
    {
        productService.deleteProduct(productId);
    }



}

