package com.example.atividademarcio.repositories.interfaces;

import java.util.List;

import com.example.atividademarcio.models.Category;


public interface CategoryRepository {
    Category findById(Long id);
    List<Category> findAll();
    void save(Category category);
    void delete(Category category);
    Category findByName(String name);
}
