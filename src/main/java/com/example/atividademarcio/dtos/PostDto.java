package com.example.atividademarcio.dtos;
import java.util.List;
import jakarta.annotation.Nullable;
import lombok.Getter;

@Getter
public class PostDto{
    @Nullable 
    String title; 
    @Nullable 
    String content;
    @Nullable 
    Long userId;
    List<Long> categories;
}
