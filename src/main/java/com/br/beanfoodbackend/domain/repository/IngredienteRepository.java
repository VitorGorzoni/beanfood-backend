package com.br.beanfoodbackend.domain.repository;

import com.br.beanfoodbackend.domain.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

    @Query("SELECT p FROM Ingrediente p WHERE p.id IN :ids")
    List<Ingrediente> findByIds(@Param("ids") List<Long> ids);
}
