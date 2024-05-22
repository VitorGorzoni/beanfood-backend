package com.br.beanfoodbackend.infrastructure.web;

import com.br.beanfoodbackend.application.services.IngredienteService;
import com.br.beanfoodbackend.application.services.ProdutoService;
import com.br.beanfoodbackend.application.services.RestauranteService;
import com.br.beanfoodbackend.domain.dto.ProdutoInsercaoDTO;
import com.br.beanfoodbackend.domain.model.Ingrediente;
import com.br.beanfoodbackend.domain.model.Produto;
import com.br.beanfoodbackend.domain.model.Restaurante;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    private final RestauranteService restauranteService;

    private final IngredienteService ingredienteService;

    private final ProdutoService produtoService;

    public ProdutoController(RestauranteService restauranteService, IngredienteService ingredienteService, ProdutoService produtoService) {
        this.restauranteService = restauranteService;
        this.ingredienteService = ingredienteService;
        this.produtoService = produtoService;
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> getProdutos() {
        List<Produto> produtos = produtoService.findAll();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable("id") Long id) {
        return produtoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/produtos")
    public ResponseEntity<?> createProduto(@RequestBody ProdutoInsercaoDTO produtoDTO) {

        Restaurante restaurante = restauranteService.findById(produtoDTO.getRestaurante_id());
        List<Ingrediente> ingredientes = ingredienteService.findByIds(produtoDTO.getIngrediente_id());

        Produto produto = Produto.builder()
                .nome(produtoDTO.getNome())
                .restaurante(restaurante)
                .ingredientes(ingredientes)
                .build();

        Produto produtoSave = produtoService.save(produto);

        return ResponseEntity.ok(produtoSave);
    }

    @PatchMapping("/produtos/{id}")
    public ResponseEntity<?> updateProduto(@PathVariable("id") Long id, @RequestBody ProdutoInsercaoDTO produtoDTO) {

        Restaurante restaurante = restauranteService.findById(produtoDTO.getRestaurante_id());
        List<Ingrediente> ingredientes = ingredienteService.findByIds(produtoDTO.getIngrediente_id());

        Produto produto = Produto.builder()
                .id(id)
                .nome(produtoDTO.getNome())
                .restaurante(restaurante)
                .ingredientes(ingredientes)
                .build();

        Produto produtoSave = produtoService.save(produto);

        return ResponseEntity.ok(produtoSave);
    }
}
