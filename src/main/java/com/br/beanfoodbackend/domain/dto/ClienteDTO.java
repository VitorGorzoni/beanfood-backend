package com.br.beanfoodbackend.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteDTO {

    private Long id;

    private String email;

    private String senha;

    private String nome;

    private String sobrenome;

    private String cpf;

    private String sexo;

    private LocalDate dataNascimento;

    private List<EnderecoDTO> enderecos;

    private List<ContatoDTO> contatos;

}
