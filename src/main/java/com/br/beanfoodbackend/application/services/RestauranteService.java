package com.br.beanfoodbackend.application.services;

import com.br.beanfoodbackend.domain.model.Restaurante;
import com.br.beanfoodbackend.domain.repository.RestauranteRepository;
import com.br.beanfoodbackend.infrastructure.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public Restaurante findById(Long restauranteId) {
        return restauranteRepository.findById(restauranteId)
                .orElseThrow(() -> new NotFoundException("Restaurante não encontrado"));
    }

    public List<Restaurante> findAll() {
        return restauranteRepository.findAll();
    }

    public Restaurante save(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }
}
