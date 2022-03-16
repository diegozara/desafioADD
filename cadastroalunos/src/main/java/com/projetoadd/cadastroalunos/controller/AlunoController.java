package com.projetoadd.cadastroalunos.controller;

import com.projetoadd.cadastroalunos.entity.Aluno;
import com.projetoadd.cadastroalunos.exception.AlunoNaoCadastradoException;
import com.projetoadd.cadastroalunos.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AlunoController {

    private AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }


    @GetMapping("/listaralunos")
    public String listarAlunos (Model model){
        model.addAttribute("listaAlunos",alunoService.listarTodos());
        return "listaralunos";
    }

 /*   @GetMapping("/{id}")
    public Aluno buscarPorId (@PathVariable Integer id) throws AlunoNaoCadastradoException{
        return alunoService.buscarPorId(id);
    }*/

    @PostMapping("/cadastroaluno")
    public String inserir (@RequestBody Aluno aluno) {
         alunoService.inserir(aluno);
         return "cadastroaluno";
    }

    @PutMapping("/{id}")
    public Aluno atualizar (@PathVariable Integer id, @RequestBody Aluno aluno) throws AlunoNaoCadastradoException {
        return alunoService.atualizar(id,aluno);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar (@PathVariable Integer id) throws AlunoNaoCadastradoException {
        alunoService.deletar(id);
    }

    @GetMapping
    public String inicio (){
     return "index";
    }

}
