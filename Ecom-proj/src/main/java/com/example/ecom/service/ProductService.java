package com.example.ecom.service;

import com.example.ecom.model.Product;
import com.example.ecom.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    public List<Product> getAll()
    {
        return productRepo.findAll();
    }

    public Product getSingle(int id) {
        return productRepo.findById(id).orElse(new Product());
    }

    public Product addProducts(Product product, MultipartFile multipartFile) throws IOException {
        product.setImageName(multipartFile.getOriginalFilename());
        product.setImageType(multipartFile.getContentType());
        product.setImageData(multipartFile.getBytes());
        return productRepo.save(product);
    }

    public Product updateProducts(int id, Product product, MultipartFile multipartFile) throws IOException {
        product.setImageData(multipartFile.getBytes());
        product.setImageType(multipartFile.getContentType());
        product.setImageName(multipartFile.getOriginalFilename());
        return productRepo.save(product);
    }
}
