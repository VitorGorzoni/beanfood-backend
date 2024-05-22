package com.br.beanfoodbackend.domain.repository;

import com.br.beanfoodbackend.domain.model.Entregador;
import com.br.beanfoodbackend.domain.model.StatusPedidoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EntregadorRepository extends JpaRepository<Entregador, Long> {

    @Query("SELECT e FROM Entregador e WHERE e.id NOT IN " +
            "(SELECT p.entregador.id FROM Pedido p WHERE p.status = :status) ORDER BY e.id")
    Optional<Entregador> findFirstEntregadorNotInStatus(@Param("status") StatusPedidoEnum status);
}
