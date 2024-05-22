package com.br.beanfoodbackend.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class PedidoDTO {

    private String status;

    private Long restaurante_id;

    private Long cliente_id;

    private List<ProdutoDTO> produtos;
}
