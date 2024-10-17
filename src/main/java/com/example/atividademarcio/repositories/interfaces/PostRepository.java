package com.example.atividademarcio.repositories.interfaces;

import java.util.List;

import com.example.atividademarcio.models.Post;

public interface PostRepository {
    Post findById(Long id);
    List<Post> findAll();
    void save(Post post);
    void merge(Post post);
    void delete(Post post);
    List<Post> findByUserId(Long userId);
}
