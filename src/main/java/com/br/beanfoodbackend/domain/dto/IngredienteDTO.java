package com.br.beanfoodbackend.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IngredienteDTO {
    private String nome;
    private String descricao;
}
