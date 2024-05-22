package com.br.beanfoodbackend.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProdutoInsercaoDTO {
    private String nome;
    private Double preco;
    private Long restaurante_id;
    private List<Long> ingrediente_id;
}
