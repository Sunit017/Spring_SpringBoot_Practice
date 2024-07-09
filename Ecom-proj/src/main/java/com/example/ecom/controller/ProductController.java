package com.example.ecom.controller;

import com.example.ecom.model.Product;
import com.example.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    public List<Product> getAllProduct()
    {
        return productService.getAll();
    }
    @GetMapping("/product/{id}")
    public Product getOne(@PathVariable int id)
    {
        return productService.getSingle(id);
    }
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart("product") Product product,
                                        @RequestPart("multipartFile") MultipartFile multipartFile) {
        try {
            Product product1 = productService.addProducts(product, multipartFile);
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int id)
    {

        Product product=productService.getSingle(id);
        byte[] image=product.getImageData();
        return  ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType()))
                .body(image);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id,
                                                @RequestPart("product") Product product,
                                                @RequestPart("multipartFile") MultipartFile multipartFile) throws IOException {

        Product product1= productService.updateProducts(id,product,multipartFile);
        if(product1 != null)
            return new ResponseEntity<>("updated",HttpStatus.OK);
        else
            return new ResponseEntity<>("Not Updated",HttpStatus.BAD_REQUEST);



    }
}
