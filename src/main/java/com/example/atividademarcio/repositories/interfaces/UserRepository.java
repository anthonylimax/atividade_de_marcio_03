package com.example.atividademarcio.repositories.interfaces;

import java.util.List;

import com.example.atividademarcio.models.Usuario;

public interface UserRepository {
    Usuario findById(Long id);
    List<Usuario> findAll();
    void save(Usuario user);
    void delete(Usuario user);
    Usuario findByEmail(String email);
}
