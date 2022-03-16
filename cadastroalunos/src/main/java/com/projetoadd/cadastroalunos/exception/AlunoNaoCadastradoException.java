package com.projetoadd.cadastroalunos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlunoNaoCadastradoException extends Exception{

    public AlunoNaoCadastradoException (Integer id){
        super("Aluno nao cadastrado com id: "+ id);
    }
}
