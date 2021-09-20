package com.funcionarios.exception;

public class FuncionarioNotFoundException extends Exception{


    private static final long serialVersionUID = 4886718030553997074L;

    public FuncionarioNotFoundException() {
        super();
    }

    public FuncionarioNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writebleStackTrace) {
        super(message, cause, enableSuppression, writebleStackTrace);
    }

    public FuncionarioNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FuncionarioNotFoundException(String message) {
        super(message);
    }

    public FuncionarioNotFoundException(Throwable cause) {
        super(cause);
    }
   
   
}
