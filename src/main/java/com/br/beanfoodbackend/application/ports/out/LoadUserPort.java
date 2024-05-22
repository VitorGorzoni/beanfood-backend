package com.br.beanfoodbackend.application.ports.out;

import com.br.beanfoodbackend.domain.model.Cliente;

public interface LoadUserPort {
    Cliente loadUser(String email, String password);
    Cliente registerUser(Cliente cliente);
}
