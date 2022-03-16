package com.projetoadd.cadastroalunos.repository;

import com.projetoadd.cadastroalunos.entity.Escola;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EscolaRepository extends JpaRepository<Escola, Integer> {
}
