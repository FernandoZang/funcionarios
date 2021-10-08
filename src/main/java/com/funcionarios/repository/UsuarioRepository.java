package com.funcionarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.funcionarios.model.Funcionario;
import com.funcionarios.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    public Usuario findByNome(String nome);
    
    public Usuario findByLogin(String login);
}
