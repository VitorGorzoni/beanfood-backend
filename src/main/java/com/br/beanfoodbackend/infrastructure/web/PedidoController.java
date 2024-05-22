package com.br.beanfoodbackend.infrastructure.web;

import com.br.beanfoodbackend.application.services.*;
import com.br.beanfoodbackend.domain.dto.PedidoDTO;
import com.br.beanfoodbackend.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PedidoController {
    private final PedidoService pedidoService;

    private final ProdutoService produtoService;

    private final RestauranteService restauranteService;

    private final ClienteService clienteService;

    private final EntregadorService entregadorService;

    @Autowired
    public PedidoController(PedidoService pedidoService, RestauranteService restauranteService, ClienteService clienteService,
                            ProdutoService produtoService,
                            EntregadorService entregadorService){
        this.pedidoService = pedidoService;
        this.restauranteService = restauranteService;
        this.clienteService = clienteService;
        this.produtoService = produtoService;
        this.entregadorService = entregadorService;
    }

    @GetMapping("/pedidos")
    public ResponseEntity<List<Pedido>> getPedidos() {
        List<Pedido> pedidos = pedidoService.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable("id") Long id) {
        return pedidoService.FindById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/pedidos")
    public ResponseEntity<Pedido> createPedido(@RequestBody PedidoDTO pedidoDTO) {

        Restaurante restaurante = restauranteService.findById(pedidoDTO.getRestaurante_id());
        Cliente cliente = clienteService.findById(pedidoDTO.getCliente_id());

        List<Produto> produtos = produtoService.findByIds(pedidoDTO.getProdutos()
                .stream()
                .map(p -> p.getProduto_id())
                .collect(Collectors.toList()));

        Entregador entregador = entregadorService.findFirstEntregadorNotInStatus(StatusPedidoEnum.EM_ANDAMENTO);

        Pedido pedido = Pedido.builder()
                .restaurante(restaurante)
                .produtos(produtos)
                .entregador(entregador)
                .cliente(cliente)
                .build();

        Pedido savedPedido = pedidoService.save(pedido);

        return ResponseEntity.ok(savedPedido);
    }
}
