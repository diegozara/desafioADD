package com.projetoadd.cadastroalunos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EscolaNaoCadastradaException extends Exception{

    public EscolaNaoCadastradaException(Integer id){
        super("Escola nao cadastrada com id: "+ id);
    }
}
