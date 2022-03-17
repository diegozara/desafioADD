package com.projetoadd.cadastroalunos.service;

import com.projetoadd.cadastroalunos.entity.Escola;
import com.projetoadd.cadastroalunos.exception.EscolaNaoCadastradaException;
import com.projetoadd.cadastroalunos.repository.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscolaService {

    private EscolaRepository escolaRepository;

    @Autowired
    public EscolaService(EscolaRepository escolaRepository) {
        this.escolaRepository = escolaRepository;
    }

    public List<Escola> listarTodos() {

        return escolaRepository.findAll();

    }

    public Escola buscarPorId(Integer id) throws EscolaNaoCadastradaException {

        Escola escola = escolaRepository.findById(id).orElseThrow(() -> new EscolaNaoCadastradaException(id));
        return escola;
    }

    public Escola inserir(Escola escola) {

        return escolaRepository.save(escola);
    }

    public Escola atualizar(Integer id, Escola escola) throws EscolaNaoCadastradaException {

        escolaRepository.findById(id).orElseThrow(() -> new EscolaNaoCadastradaException(id));
        escola.setId(id);

        return escolaRepository.save(escola);
    }

    public void deletar(Integer id) throws EscolaNaoCadastradaException {

        verificarExistencia(id);

        escolaRepository.deleteById(id);
    }


    private Escola verificarExistencia(Integer id) throws EscolaNaoCadastradaException {
        return escolaRepository.findById(id)
                .orElseThrow(() -> new EscolaNaoCadastradaException(id));
    }
}
