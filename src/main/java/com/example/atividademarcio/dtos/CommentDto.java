package com.example.atividademarcio.dtos;

public record CommentDto(
    Long userId,
    Long postId,
    String content) {
    
}
