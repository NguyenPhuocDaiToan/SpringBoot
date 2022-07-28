package com.example.productmanagement.service;

import com.example.productmanagement.model.Category;
import com.example.productmanagement.repository.CategoryRepository;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
}
