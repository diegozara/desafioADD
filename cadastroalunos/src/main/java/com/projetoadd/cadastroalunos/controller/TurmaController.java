package com.projetoadd.cadastroalunos.controller;


import com.projetoadd.cadastroalunos.entity.Turma;
import com.projetoadd.cadastroalunos.exception.TurmaNaoCadastradaException;
import com.projetoadd.cadastroalunos.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/turmas")
public class TurmaController {

    private TurmaService turmaService;

    @Autowired
    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @GetMapping
    public List<Turma> listarTurma(){

        return turmaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Turma buscarPorId(@PathVariable Integer id) throws TurmaNaoCadastradaException {
        return turmaService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Turma inserir (@RequestBody Turma turma) {
        return turmaService.inserir(turma);
    }

    @PutMapping ("/{id}")
    public Turma atualizar (@PathVariable Integer id, @RequestBody Turma turma) throws TurmaNaoCadastradaException {
        return turmaService.atualizar(id,turma);
    }

    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar (@PathVariable Integer id) throws TurmaNaoCadastradaException {
        turmaService.deletar(id);
    }

}
