package com.br.beanfoodbackend.application.services;

import com.br.beanfoodbackend.domain.model.Entregador;
import com.br.beanfoodbackend.domain.model.StatusPedidoEnum;
import com.br.beanfoodbackend.domain.repository.EntregadorRepository;
import com.br.beanfoodbackend.infrastructure.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository entregadorRepository;

    public Entregador findById(Long entregadorId) {
        return entregadorRepository.findById(entregadorId)
                .orElseThrow(() -> new NotFoundException("Entregador não encontrado"));
    }

    public Entregador findFirstEntregadorNotInStatus(StatusPedidoEnum status) {
        return entregadorRepository.findFirstEntregadorNotInStatus(status)
                .orElseThrow(() -> new NotFoundException("Entregador não encontrado"));
    }

    public Entregador save(Entregador entregador) {
        return entregadorRepository.save(entregador);
    }
}
