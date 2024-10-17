package com.example.atividademarcio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atividademarcio.dtos.CommentDto;
import com.example.atividademarcio.models.Comment;
import com.example.atividademarcio.repositories.interfaces.CommentRepository;
import com.example.atividademarcio.repositories.interfaces.PostRepository;
import com.example.atividademarcio.repositories.interfaces.UserRepository;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository pRepository;
    @Autowired
    private UserRepository uRepository;

    public Comment findById(Long id) {
        return commentRepository.findById(id);
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }
    public void update(Comment comment){
        commentRepository.save(comment);
    }

    public void save(CommentDto comment) {
        var post = pRepository.findById(comment.postId());
        var user = uRepository.findById(comment.userId());
        var newcomment = new Comment();
        newcomment.setPost(post);
        newcomment.setUser(user);
        newcomment.setContent(comment.content());
        commentRepository.save(newcomment);
    }

    public void delete(Long id) {
        Comment comment = commentRepository.findById(id);
        if (comment != null) {
            commentRepository.delete(comment);
        }
    }
    public List<Comment> findByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public List<Comment> findByUserId(Long userId) {
        return commentRepository.findByUserId(userId);
    }
}
