package com.projetoadd.cadastroalunos.controller;

import com.projetoadd.cadastroalunos.entity.Aluno;
import com.projetoadd.cadastroalunos.exception.AlunoNaoCadastradoException;
import com.projetoadd.cadastroalunos.service.AlunoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AlunoController {

    private AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }


    @GetMapping("/alunos/listaralunos")
    @ApiOperation(value = "Método de acesso aos Alunos cadastrados")
    public String listarAlunos (Model model){
        model.addAttribute("listaAlunos",alunoService.listarTodos());
        return "listaralunos";
    }

    @GetMapping("/alunos/novoaluno")
    @ApiOperation(value = "Acesso ao formulário de cadastro de Alunos")
    public String formInserir (@ModelAttribute("aluno") Aluno aluno) {
         return "cadastroaluno";
    }

    @GetMapping("/alunos/{id}")
    @ApiOperation(value = "Acesso do formulário de alteração de cadastro de Alunos")
    public String alterarAluno(@PathVariable ("id") Integer id, Model model) throws AlunoNaoCadastradoException {
        model.addAttribute("aluno", alunoService.buscarPorId(id));
        return "cadastroaluno";
    }

    @GetMapping("/alunos/excluir/{id}")
    @ApiOperation(value = "Método para excluir Alunos cadastrados (feito no verbo GET por conta do Thymeleaf)")
    public String excluirAluno (@PathVariable ("id") Integer id) throws AlunoNaoCadastradoException {
        alunoService.deletar(id);
        return "redirect:/alunos/listaralunos";
    }

    @PostMapping("/alunos/cadastraraluno")
    @ApiOperation(value = "Método de alteração e cadastro dos Alunos (mesmo formulário POST/PUT)")
    public String inserirAluno (@ModelAttribute("aluno") Aluno aluno){
        alunoService.inserir(aluno);
        return "redirect:/alunos/listaralunos";
    }

    @GetMapping
    @ApiOperation(value = "Método para acesso da tela inicial da API")
    public String inicio (){
     return "index";
    }

}
