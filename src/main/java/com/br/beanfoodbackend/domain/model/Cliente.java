package com.br.beanfoodbackend.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", unique = true)
    private String email;
    private String senha;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String sexo;
    private LocalDate dataNascimento;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Endereco> enderecos;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Contato> contatos;
}
