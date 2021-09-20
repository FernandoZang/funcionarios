package com.funcionarios.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Regra implements GrantedAuthority {
    
    /**
     * 
     */
    private static final long serialVersionUID = 752124578034644607L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    
    @Override
    public String getAuthority() {
        return  this.nome;
    }

    public Regra(String nome) {
        this.nome = nome;
    }
    public Regra() {
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    

    
}
