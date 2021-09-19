package com.funcionarios.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import lombok.Value;



@Table
@Entity
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @Size(min = 2, max = 30)
    private String nome;
    
    @NotNull(message = "Sobrenome não pode ser nulo")
    @Size(min = 2, max = 50)
    private String sobrenome;
    
    @Email(message = "Insira um e-mail válido")
    private String email;

    @Pattern(regexp = "[0-9]+", message = "Insira apenas números")
    private String PIS;

    
    
    
    
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPIS() {
        return PIS;
    }

    public void setPIS(String pIS) {
        PIS = pIS;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    
    
    
}
