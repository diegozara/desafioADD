package com.projetoadd.cadastroalunos.controller;

import com.projetoadd.cadastroalunos.entity.Aluno;
import com.projetoadd.cadastroalunos.exception.AlunoNaoCadastradoException;
import com.projetoadd.cadastroalunos.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class AlunoController {

    private AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }


    @GetMapping("/alunos/listaralunos")
    public String listarAlunos (Model model){
        model.addAttribute("listaAlunos",alunoService.listarTodos());
        return "listaralunos";
    }

    @GetMapping("/alunos/novoaluno")
    public String formInserir (@ModelAttribute("aluno") Aluno aluno) {
         return "cadastroaluno";
    }

    @GetMapping("/alunos/{id}")
    public String alterarAluno(@PathVariable ("id") Integer id, Model model) throws AlunoNaoCadastradoException {
        model.addAttribute("aluno", alunoService.buscarPorId(id));
        return "cadastroaluno";
    }

    @GetMapping("/alunos/excluir/{id}")
    public String excluirAluno (@PathVariable ("id") Integer id) throws AlunoNaoCadastradoException {
        alunoService.deletar(id);
        return "redirect:/alunos/listaralunos";
    }

    @PostMapping("/alunos/cadastraraluno")
    public String inserirAluno (@ModelAttribute("aluno") Aluno aluno){
        alunoService.inserir(aluno);
        return "redirect:/alunos/listaralunos";
    }


  /*  @PutMapping("/{id}")
    public Aluno atualizar (@PathVariable Integer id, @RequestBody Aluno aluno) throws AlunoNaoCadastradoException {
        return alunoService.atualizar(id,aluno);
    }

    @DeleteMapping("/alunos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar (@PathVariable Integer id) throws AlunoNaoCadastradoException {
        alunoService.deletar(id);
    }*/

    @GetMapping
    public String inicio (){
     return "index";
    }

}
