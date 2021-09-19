package com.funcionarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.funcionarios.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

    Funcionario findById(long id);
    
}
