package com.funcionarios.controller;

import java.util.List;


import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.funcionarios.exception.FuncionarioNotFoundException;
import com.funcionarios.model.Funcionario;
import com.funcionarios.service.FuncionarioService;

@RestController()
@RequestMapping(value = "/funcionario")
public class FuncionarioController {
    
    @Autowired
    FuncionarioService funcionarioService;
    
    @GetMapping("/list")
    public List<Funcionario> list(){
        return funcionarioService.list();
    }
    
    @GetMapping("/get/{id}")
    public Funcionario get(@PathVariable(value = "id") long id) throws FuncionarioNotFoundException {
        return funcionarioService.get(id);
    }
    
    @PostMapping("/add")
    public void add(@Valid @RequestBody Funcionario funcionario) {
        funcionarioService.add(funcionario);
    }
    
    @PutMapping("/update")
    public void update(@Valid @RequestBody Funcionario funcionario) throws FuncionarioNotFoundException {
        funcionarioService.update(funcionario);
    }
    
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable(value = "id") long id) throws FuncionarioNotFoundException {
        funcionarioService.delete(id);
    }
    
}
