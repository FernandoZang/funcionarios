package com.funcionarios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import com.funcionarios.exception.FuncionarioNotFoundException;
import com.funcionarios.model.Funcionario;
import com.funcionarios.repository.FuncionarioRepository;
import com.funcionarios.service.FuncionarioService;

@SpringBootTest
@WebAppConfiguration
public class FuncionarioServiceTest {
    
    @Autowired
    private FuncionarioService funcionarioService;    
    @Autowired
    private FuncionarioRepository FuncionarioRepository; 
    
    
    
    
    @Test // Verificar se está pegando o funcionario pelo id corretamente, ou lance a FuncionarioNotFoundException caso não encontre
    public void buscarPorIdTest() throws FuncionarioNotFoundException {
        Funcionario funcionario = null;
        try {
             funcionario = funcionarioService.get(1L);
             assertEquals(1, funcionario.getId());
        }
        catch (FuncionarioNotFoundException e) {
            assertTrue(true);
        }
        
    }
    
    @Test // Verificar se lança exception caso não enconte funcionario com o ID passado
    public void buscarPorIdNaoEncontradoTest() throws FuncionarioNotFoundException {
        boolean teste = false;
        Funcionario funcionario = null;
        try {
            funcionario = funcionarioService.get(1L);
        }
        catch (FuncionarioNotFoundException e) {
            teste = true;
        }
        assertTrue(teste);
    }
    

    
    
    
    
}
