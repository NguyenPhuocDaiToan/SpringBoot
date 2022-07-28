package com.blog.service;

import java.util.List;

public interface GenerateService<T, U> {
    List<T> findAll();
    T findById(U id);
    void save(T t);
    void deleteById(U id);
}
