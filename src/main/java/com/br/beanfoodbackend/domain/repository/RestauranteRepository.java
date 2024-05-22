package com.br.beanfoodbackend.domain.repository;

import com.br.beanfoodbackend.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}
