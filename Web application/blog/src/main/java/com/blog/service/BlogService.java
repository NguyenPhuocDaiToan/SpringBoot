package com.blog.service;


import com.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface BlogService extends GenerateService<Blog, Integer> {
    Page<Blog> findAllWithPage(Pageable pageable);
}
