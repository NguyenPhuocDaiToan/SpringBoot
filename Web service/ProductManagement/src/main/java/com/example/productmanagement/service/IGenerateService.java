package com.example.productmanagement.service;

import java.util.List;

public interface IGenerateService<T, U> {
    List<T> findAll();
    T findById(U id);
    void save(T t);
    void deleteById(U id);
}
