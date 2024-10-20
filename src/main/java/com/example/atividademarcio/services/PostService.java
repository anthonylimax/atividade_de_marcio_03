package com.example.atividademarcio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atividademarcio.dtos.PostDto;
import com.example.atividademarcio.dtos.CreatePostDto;
import com.example.atividademarcio.models.Category;
import com.example.atividademarcio.models.Post;
import com.example.atividademarcio.models.Usuario;
import com.example.atividademarcio.repositories.interfaces.CategoryRepository;
import com.example.atividademarcio.repositories.interfaces.PostRepository;
import com.example.atividademarcio.repositories.interfaces.UserRepository;

import java.util.List;
import java.util.ArrayList;


@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    public Post findById(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public void save(CreatePostDto create) {
        Post newPost = new Post();
        Usuario user = userRepository.findById(create.getUserId().longValue());
        newPost.setContent(create.getContent());
        newPost.setTitle(create.getTitle());
        newPost.setUser(user);
        List<Category> categories = new ArrayList<>();
        for(int i = 0; i > create.getCategories().size(); i++){
            var category = categoryRepository.findById(create.getCategories().get(i).longValue());
            
            categories.add(category);
        }
        newPost.setCategories(categories);
        postRepository.save(newPost);
    }
    
    public void update(PostDto post) {
        var newPost = new Post();
        newPost.setContent(post.getContent());
        newPost.setTitle(post.getTitle());
        newPost.setId(post.getUserId().intValue());
        postRepository.save(newPost);
    }

    

    public void delete(Long id) {
        Post post = postRepository.findById(id);
        if (post != null) {
            postRepository.delete(post);
        }
    }

    public List<Post> findByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }
}
