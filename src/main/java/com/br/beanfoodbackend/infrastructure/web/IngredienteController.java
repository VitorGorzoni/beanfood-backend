package com.br.beanfoodbackend.infrastructure.web;

import com.br.beanfoodbackend.application.services.IngredienteService;
import com.br.beanfoodbackend.domain.dto.IngredienteDTO;
import com.br.beanfoodbackend.domain.model.Ingrediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngredienteController {

    private final IngredienteService ingredienteService;

    @Autowired
    public IngredienteController(IngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
    }

    @GetMapping("/ingredientes")
    public ResponseEntity<?> getIngredientes() {
        return ResponseEntity.ok(ingredienteService.findAll());
    }

    @GetMapping("/ingredientes/{id}")
    public ResponseEntity<?> getIngredienteById(Long id) {
        return ResponseEntity.ok(ingredienteService.findById(id));
    }

    @PostMapping("/ingredientes")
    public ResponseEntity<?> createIngrediente(@RequestBody IngredienteDTO ingredienteDTO) {
        return ResponseEntity.ok(ingredienteService.save(mapToEntity(ingredienteDTO)));
    }
     public Ingrediente mapToEntity(IngredienteDTO ingredienteDTO) {
         return Ingrediente.builder()
                 .nome(ingredienteDTO.getNome())
                 .descricao(ingredienteDTO.getDescricao())
                 .build();
     }
}
