package com.example.atividademarcio.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.atividademarcio.models.Usuario;
import com.example.atividademarcio.repositories.interfaces.UserRepository;

import java.util.List;

@Service
public class UserService{
    
    @Autowired
    private UserRepository userRepository;


    public Usuario findById(Long id) {
        return userRepository.findById(id);
    }

    public List<Usuario> findAll() {
        return userRepository.findAll();
    }

    public void save(Usuario user) {
        userRepository.save(user);
    }

    public void delete(Long id) {
        Usuario user = userRepository.findById(id);
        if (user != null) {
            userRepository.delete(user);
        }
    }

    public Usuario findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
