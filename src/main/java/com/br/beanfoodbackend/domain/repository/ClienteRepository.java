package com.br.beanfoodbackend.domain.repository;

import com.br.beanfoodbackend.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByEmailAndSenha(String email, String password);
    Cliente findByEmail(String email);
}
