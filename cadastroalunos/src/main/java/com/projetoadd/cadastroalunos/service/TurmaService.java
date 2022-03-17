package com.projetoadd.cadastroalunos.service;

import com.projetoadd.cadastroalunos.entity.Turma;
import com.projetoadd.cadastroalunos.exception.TurmaNaoCadastradaException;
import com.projetoadd.cadastroalunos.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    private TurmaRepository turmaRepository;

    @Autowired
    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }


    public List<Turma> listarTodos() {

        return turmaRepository.findAll();

    }

    public Turma buscarPorId(Integer id) throws TurmaNaoCadastradaException {

        Turma turma = turmaRepository.findById(id).orElseThrow(() -> new TurmaNaoCadastradaException(id));
        return turma;
    }

    public Turma inserir(Turma turma) {

        return turmaRepository.save(turma);
    }

    public Turma atualizar(Integer id, Turma turma) throws TurmaNaoCadastradaException {

        turmaRepository.findById(id).orElseThrow(() -> new TurmaNaoCadastradaException(id));
        turma.setId(id);

        return turmaRepository.save(turma);
    }

    public void deletar(Integer id) throws TurmaNaoCadastradaException {

        verificarExistencia(id);

        turmaRepository.deleteById(id);
    }

    private Turma verificarExistencia(Integer id) throws TurmaNaoCadastradaException {
        return turmaRepository.findById(id)
                .orElseThrow(() -> new TurmaNaoCadastradaException(id));
    }
}
