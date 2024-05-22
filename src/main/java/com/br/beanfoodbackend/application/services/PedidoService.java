package com.br.beanfoodbackend.application.services;

import com.br.beanfoodbackend.domain.model.Pedido;
import com.br.beanfoodbackend.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> FindById(Long id) {
        return pedidoRepository.findById(id);
    }

    public List<Pedido> findByIds(@Param("ids") List<Long> ids) {
        return pedidoRepository.findByIds(ids);
    }
}
