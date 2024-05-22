package com.br.beanfoodbackend.application.services;

import com.br.beanfoodbackend.domain.model.Cliente;
import com.br.beanfoodbackend.domain.repository.ClienteRepository;
import com.br.beanfoodbackend.infrastructure.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(Long clientId) {
        return clienteRepository.findById(clientId)
                .orElseThrow(() -> new NotFoundException("Restaurante não encontrado"));
    }
}
