package com.projetoadd.cadastroalunos.controller;

import com.projetoadd.cadastroalunos.entity.Escola;
import com.projetoadd.cadastroalunos.exception.EscolaNaoCadastradaException;
import com.projetoadd.cadastroalunos.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escolas")
public class EscolaController {

    private EscolaService escolaService;

    @Autowired
    public EscolaController(EscolaService escolaService) {
        this.escolaService = escolaService;
    }

    @GetMapping
    public List<Escola> listarEscola(){

        return escolaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Escola buscarPorId(@PathVariable Integer id) throws EscolaNaoCadastradaException {
        return escolaService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Escola inserir (@RequestBody Escola escola) {
        return escolaService.inserir(escola);
    }

    @PutMapping ("/{id}")
    public Escola atualizar (@PathVariable Integer id, @RequestBody Escola escola) throws EscolaNaoCadastradaException {
        return escolaService.atualizar(id,escola);
    }

    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar (@PathVariable Integer id) throws EscolaNaoCadastradaException {
        escolaService.deletar(id);
    }

}
