package com.example.atividademarcio.repositories.interfaces;

import java.util.List;

import com.example.atividademarcio.models.Comment;

public interface CommentRepository {
    Comment findById(Long id);
    List<Comment> findAll();
    void save(Comment comment);
    void delete(Comment comment);
    List<Comment> findByPostId(Long postId);
    List<Comment> findByUserId(Long userId);
}