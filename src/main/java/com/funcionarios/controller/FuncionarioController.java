package com.funcionarios.controller;

import java.util.List;


import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController()
@RequestMapping(value = "/funcionario")
@Api(value = "Funcionários API REST")
@CrossOrigin(origins = "*") //Qualquer domínio pode acessar esse controller
public class FuncionarioController {
    
    @Autowired
    FuncionarioService funcionarioService;
    
    @GetMapping("/list")
    @ApiOperation(value = "Retorna uma lista de Funcionarios")
    public List<Funcionario> list(){
        return funcionarioService.list();
    }
    
    @GetMapping("/get/{id}")
    @ApiOperation(value = "Retorna o funcionário correspondente ao ID")
    public Funcionario get(@PathVariable(value = "id") long id) throws FuncionarioNotFoundException {
        return funcionarioService.get(id);
    }
    
    @PostMapping("/add")
    @ApiOperation(value = "Cadastra o Funcionário passado por parâmetro")
    public void add(@Valid @RequestBody Funcionario funcionario) {
        funcionarioService.add(funcionario);
    }
    
    @PutMapping("/update")
    @ApiOperation(value = "Atualiza o Funcionario passado")
    public void update(@Valid @RequestBody Funcionario funcionario) throws FuncionarioNotFoundException {
        funcionarioService.update(funcionario);
    }
    
    @DeleteMapping("delete/{id}")
    @ApiOperation(value = "Deleta oo funcionário que corresponde ao ID passado")
    public void delete(@PathVariable(value = "id") long id) throws FuncionarioNotFoundException {
        funcionarioService.delete(id);
    }
    
}
