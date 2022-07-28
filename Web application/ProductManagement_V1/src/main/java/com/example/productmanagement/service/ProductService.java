package com.example.productmanagement.service;

import com.example.productmanagement.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product findById(Integer id);
    void save(Product product);
    void deleteById(Integer id);
}
