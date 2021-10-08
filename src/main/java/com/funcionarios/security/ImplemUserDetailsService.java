package com.funcionarios.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.funcionarios.model.Usuario;
import com.funcionarios.repository.UsuarioRepository;

@Repository
public class ImplemUserDetailsService implements UserDetailsService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(username);
        if(usuario==null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return usuario;
    }

}
