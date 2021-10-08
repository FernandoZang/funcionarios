package com.funcionarios.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String email;
    
    private String login;
    
    private String password;
    
    
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Regra> regras;
    
    public Usuario() {
        // TODO Auto-generated constructor stub
    }

    public Usuario(Long id, String nome, String email, String login, String password, List<Regra> regras) {
        super();
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.password = password;
        this.regras = regras;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }


    public List<Regra> getRegras() {
        return regras;
    }
    
    public void setRegras(List<Regra> regras) {
        this.regras = regras;
    }                                                                                                                                                                                                                                                                                                                                                                                        

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getPassword() {
        return this.password;
    }


    
    
    
    
    
}
