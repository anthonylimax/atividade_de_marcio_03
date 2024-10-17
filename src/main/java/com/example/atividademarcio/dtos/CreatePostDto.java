package com.example.atividademarcio.dtos;
import java.util.List;
import lombok.Getter;


@Getter
public class CreatePostDto {
    private Long userId;
    private String content;
    private String title;
    private List<Long> categories;
}
