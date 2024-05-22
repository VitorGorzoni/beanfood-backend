package com.br.beanfoodbackend.infrastructure.web;

import com.br.beanfoodbackend.application.services.RestauranteService;
import com.br.beanfoodbackend.domain.dto.RestauranteDTO;
import com.br.beanfoodbackend.domain.model.Restaurante;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestauranteController {

    private final RestauranteService restauranteService;

    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }
    @GetMapping("/restaurantes")
    public ResponseEntity<?> getRestaurantes() {
        return ResponseEntity.ok(restauranteService.findAll());
    }

    @GetMapping("/restaurantes/{id}")
    public ResponseEntity<?> getRestauranteById(Long id) {
        return ResponseEntity.ok(restauranteService.findById(id));
    }

    @PostMapping("/restaurantes")
    public ResponseEntity<?> createRestaurante(@RequestBody RestauranteDTO restauranteDTO) {

        Restaurante restaurante = Restaurante.builder()
                .nome(restauranteDTO.getNome())
                .cnpj(restauranteDTO.getCnpj())
                .build();

        restauranteService.save(restaurante);

        return ResponseEntity.ok(restaurante);
    }
}
