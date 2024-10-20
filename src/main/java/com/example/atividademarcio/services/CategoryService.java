package com.example.atividademarcio.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atividademarcio.models.Category;
import com.example.atividademarcio.repositories.interfaces.CategoryRepository;

import java.util.List;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public Category findById(Long id) {
        return categoryRepository.findById(id);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }
    public void delete(Long id) {
        Category category = categoryRepository.findById(id);
        if (category != null) {
            categoryRepository.delete(category);
        }
    }

    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }
}
