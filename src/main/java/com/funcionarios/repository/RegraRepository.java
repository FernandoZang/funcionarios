package com.funcionarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.funcionarios.model.Regra;

public interface RegraRepository extends JpaRepository<Regra, Long>{
    public Regra findByNome(String nome);
}
