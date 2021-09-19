package com.funcionarios.repository;

import com.funcionarios.model.Usuario;

public interface UsuarioRepository {
    public Usuario findByNome(String login);
}
