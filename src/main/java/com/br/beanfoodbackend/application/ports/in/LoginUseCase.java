package com.br.beanfoodbackend.application.ports.in;

import com.br.beanfoodbackend.domain.model.Cliente;

public interface LoginUseCase {
    Cliente login(String email, String senha);

    Cliente registrar(Cliente cliente);
}
