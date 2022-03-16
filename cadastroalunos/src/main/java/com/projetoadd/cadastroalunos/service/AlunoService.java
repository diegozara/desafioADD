package com.projetoadd.cadastroalunos.service;

import com.projetoadd.cadastroalunos.entity.Aluno;
import com.projetoadd.cadastroalunos.exception.AlunoNaoCadastradoException;
import com.projetoadd.cadastroalunos.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> listarTodos (){
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId (Integer id) throws AlunoNaoCadastradoException {
        return alunoRepository.findById(id).orElseThrow(() -> new AlunoNaoCadastradoException(id));
    }

    public Aluno inserir (Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno atualizar (Integer id, Aluno aluno) throws AlunoNaoCadastradoException{

        alunoRepository.findById(id).orElseThrow(() -> new AlunoNaoCadastradoException(id));
        aluno.setId(id);
        return alunoRepository.save(aluno);
    }

    public void deletar (Integer id) throws AlunoNaoCadastradoException{

        verificarExistencia(id);
        alunoRepository.deleteById(id);

    }

    private Aluno verificarExistencia(Integer id) throws AlunoNaoCadastradoException {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new AlunoNaoCadastradoException(id));
    }

}
