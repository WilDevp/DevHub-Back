package com.devhubback.service;

import com.devhubback.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    List<Usuario>findAll();
    Optional<Usuario>findById(Integer id);
    Usuario create(Usuario usuario);
    Usuario update(Usuario usuario);
    void delete(Integer id);
}
