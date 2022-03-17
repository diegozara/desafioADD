package com.projetoadd.cadastroalunos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TurmaNaoCadastradaException extends Exception{

    public TurmaNaoCadastradaException(Integer id){
        super("Turma nao cadastrada com id: "+ id);
    }
}
