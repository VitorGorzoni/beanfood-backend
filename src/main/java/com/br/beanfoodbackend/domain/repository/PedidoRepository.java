package com.br.beanfoodbackend.domain.repository;

import com.br.beanfoodbackend.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Query("SELECT p FROM Pedido p WHERE p.id IN :ids")
    List<Pedido> findByIds(@Param("ids") List<Long> ids);
}
