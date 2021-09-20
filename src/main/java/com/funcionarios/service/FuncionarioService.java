package com.funcionarios.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funcionarios.exception.FuncionarioNotFoundException;
import com.funcionarios.model.Funcionario;
import com.funcionarios.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;
    
    public List<Funcionario> list(){
        return funcionarioRepository.findAll();
    }
    

    public Funcionario get(long id) throws FuncionarioNotFoundException {
        Optional<Funcionario> funcionario = getOption(id);
        if(funcionario.isPresent()) {
            return funcionario.get();
        }
        else {
            throw new FuncionarioNotFoundException("Funcionario id {" + id + "} " + "não encotrado" );
        }
    }
    
    public void add(Funcionario funcionario) {
        this.funcionarioRepository.save(funcionario);
    }

    public void update(Funcionario funcionario) throws FuncionarioNotFoundException {
        Optional<Funcionario> f = getOption(funcionario.getId());
        if(f.isPresent()) {
            this.funcionarioRepository.save(f.get());
        }
        else {
            throw new FuncionarioNotFoundException("Funcionario id {" + funcionario.getId() + "} " + "não encotrado" );
        }
    }

    public void delete(long id) throws FuncionarioNotFoundException {
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
