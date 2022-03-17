package com.projetoadd.cadastroalunos.inserirbancodados;

import com.projetoadd.cadastroalunos.entity.Aluno;
import com.projetoadd.cadastroalunos.entity.Endereco;
import com.projetoadd.cadastroalunos.entity.Escola;
import com.projetoadd.cadastroalunos.entity.Turma;
import com.projetoadd.cadastroalunos.repository.AlunoRepository;
import com.projetoadd.cadastroalunos.repository.EnderecoRepository;
import com.projetoadd.cadastroalunos.repository.EscolaRepository;
import com.projetoadd.cadastroalunos.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Component
@Transactional
public class PopularBancoDados implements CommandLineRunner {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EscolaRepository escolaRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    @Override
    public void run(String... args) throws Exception {



        Endereco end1 = new Endereco("Rua Joaquim Ozorio, numero 70", "casa", "Jd. das Neves", "São Paulo", "SP");
        Endereco end2 = new Endereco("Rua General Duque Silva, numero 120", "casa", "Santa Lucia", "São Paulo", "SP");
        Endereco end3 = new Endereco("Rua Roberto Gamito, numero 22", "apartamento", "Jd. das Neves", "São Paulo", "SP");
        Endereco end4 = new Endereco("Avenida Lima Ferreira, numero 1054", "casa", "Jd. das Neves", "São Paulo", "SP");

        enderecoRepository.save(end1);
        enderecoRepository.save(end2);
        enderecoRepository.save(end3);
        enderecoRepository.save(end4);

        Escola escol1 = new Escola("Dr. Clybas Ferraz", end1);
        Escola escol2 = new Escola("UNIP", end2);
        Escola escol3 = new Escola("Fisk", end3);
        Escola escol4 = new Escola("FATEC", end4);

        escolaRepository.save(escol1);
        escolaRepository.save(escol2);
        escolaRepository.save(escol3);
        escolaRepository.save(escol4);

        Turma turma1 = new Turma("Ciencia da Computação", 80);
        Turma turma2 = new Turma("Analise de Sistemas", 80);
        Turma turma3 = new Turma("Tecnico em Informatica", 30);
        Turma turma4 = new Turma("Engenharia da Computação", 90);

        turmaRepository.save(turma1);
        turmaRepository.save(turma2);
        turmaRepository.save(turma3);
        turmaRepository.save(turma4);

        Aluno a1 = new Aluno("Joao", LocalDate.of(1990,04,12), turma1);
        Aluno a2 = new Aluno("Maria", LocalDate.of(1985,01,21), turma2);
        Aluno a3 = new Aluno("Pedro", LocalDate.of(1995,10,15), turma3);
        Aluno a4 = new Aluno("Jose", LocalDate.of(1987,02,27), turma4);

        alunoRepository.save(a1);
        alunoRepository.save(a2);
        alunoRepository.save(a3);
        alunoRepository.save(a4);

    }
}
