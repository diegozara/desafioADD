package com.projetoadd.cadastroalunos.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Turma {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   private String nome;

   private Integer capacidade;

   public Turma(String nome, Integer capacidade) {
      this.nome = nome;
      this.capacidade = capacidade;
   }
}
