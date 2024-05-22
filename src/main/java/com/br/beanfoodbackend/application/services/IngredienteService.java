package com.br.beanfoodbackend.application.services;

import com.br.beanfoodbackend.domain.model.Ingrediente;
import com.br.beanfoodbackend.domain.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredienteService {
    @Autowired
    private IngredienteRepository ingredienteRepository;

    public List<Ingrediente> findByIds(@Param("ids") List<Long> ids) {
        return ingredienteRepository.findByIds(ids);
    }

    public List<Ingrediente> findAll() {
        return ingredienteRepository.findAll();
    }

    public Ingrediente save(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }

    public Ingrediente findById(Long id) {
        return ingredienteRepository.findById(id).orElse(null);
    }
}
