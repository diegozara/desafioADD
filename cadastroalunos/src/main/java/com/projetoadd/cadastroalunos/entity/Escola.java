package com.projetoadd.cadastroalunos.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Escola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @OneToOne
    private Endereco endereco;

    public Escola(String nome, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }
}
