package com.br.beanfoodbackend.application.services;

import com.br.beanfoodbackend.application.ports.in.LoginUseCase;
import com.br.beanfoodbackend.application.ports.out.LoadUserPort;
import com.br.beanfoodbackend.domain.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginUseCase {

    private final LoadUserPort loadUserPort;

    @Autowired
    public LoginService(LoadUserPort loadUserPort) {
        this.loadUserPort = loadUserPort;
    }

    @Override
    public Cliente login(String email, String password) {
        return loadUserPort.loadUser(email, password);
    }

    @Override
    public Cliente registrar(Cliente cliente) {
        return loadUserPort.registerUser(cliente);
    }
}
