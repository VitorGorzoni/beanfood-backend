package com.br.beanfoodbackend.infrastructure.adapter;

import com.br.beanfoodbackend.application.ports.out.LoadUserPort;
import com.br.beanfoodbackend.domain.model.Cliente;
import com.br.beanfoodbackend.domain.repository.ClienteRepository;
import com.br.beanfoodbackend.infrastructure.exception.RecordAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class LoadUserAdapter implements LoadUserPort {

    private final ClienteRepository clienteRepository;

    @Autowired
    public LoadUserAdapter(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente loadUser(String email, String password) {
        return clienteRepository.findByEmailAndSenha(email, password);
    }

    @Override
    public Cliente registerUser(Cliente cliente) {

        if (Objects.nonNull(clienteRepository.findByEmail(cliente.getEmail()))) {
            throw new RecordAlreadyExistsException("Email já cadastrado");
        }

        return clienteRepository.save(cliente);
    }
}
