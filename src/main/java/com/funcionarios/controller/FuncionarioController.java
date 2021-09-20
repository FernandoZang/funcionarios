package com.funcionarios.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.metamodel.Metamodel;
import javax.validation.Valid;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
import com.funcionarios.repository.FuncionarioRepository;

@RestController()
@RequestMapping(value = "/funcionario")
public class FuncionarioController {
    
    @Autowired
    FuncionarioRepository funcionarioRepository;
    
    @GetMapping("/list")
    public List<Funcionario> list(){
        return funcionarioRepository.findAll();
    }
    
    @GetMapping("/get/{id}")
    public Funcionario get(@PathVariable(value = "id") long id) throws FuncionarioNotFoundException {
        Optional<Funcionario> funcionario = getOption(id);
        if(funcionario.isPresent()) {
            return funcionario.get();
        }
        else {
            throw new FuncionarioNotFoundException("Funcionario id {" + id + "} " + "não encotrado" );
        }
    }
    
    @PostMapping("/add")
    public void add(@Valid @RequestBody Funcionario funcionario) {
        this.funcionarioRepository.save(funcionario);
    }
    
    @PutMapping("/update")
    public void update(@Valid @RequestBody Funcionario funcionario) throws FuncionarioNotFoundException {
        Optional<Funcionario> f = getOption(funcionario.getId());
        if(f.isPresent()) {
            this.funcionarioRepository.save(f.get());
        }
        else {
            throw new FuncionarioNotFoundException("Funcionario id {" + funcionario.getId() + "} " + "não encotrado" );
        }
    }
    
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable(value = "id") long id) throws FuncionarioNotFoundException {
        Optional<Funcionario> funcionario = getOption(id);
        if(funcionario.isPresent()) {
            this.funcionarioRepository.deleteById(id); 
        }
        else {
            throw new FuncionarioNotFoundException("Funcionario id {" + id + "} " + "não encotrado" );
        }
    }
    
    private Optional<Funcionario> getOption(Long id){
        Optional<Funcionario> funcionarioOptional = this.funcionarioRepository.findById(id);
        return funcionarioOptional;
    }
    
}
