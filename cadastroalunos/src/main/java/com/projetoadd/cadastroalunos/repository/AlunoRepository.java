package com.projetoadd.cadastroalunos.repository;

import com.projetoadd.cadastroalunos.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
