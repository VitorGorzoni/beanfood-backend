package com.br.beanfoodbackend.domain.dto;

import com.br.beanfoodbackend.domain.model.Pedido;
import com.br.beanfoodbackend.domain.model.Produto;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class RestauranteDTO {
    private Long id;

    private String nome;

    private String cnpj;

    @OneToMany(mappedBy = "restaurante")
    private List<Produto> produtos;

    @OneToMany(mappedBy = "restaurante")
    private List<Pedido> pedidos;
}
