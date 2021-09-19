package com.funcionarios.test;

import com.funcionarios.model.Funcionario;

public class TestFuncionario {

    public static void main(String[] args) {
        Funcionario f1 = new Funcionario();
        f1.setEmail("fernando.zang@teste.com.br");
        System.out.println(f1.getEmail());
        
        
    }
}
