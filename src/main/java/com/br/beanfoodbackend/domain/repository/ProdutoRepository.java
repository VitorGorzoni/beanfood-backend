package com.br.beanfoodbackend.domain.repository;

import com.br.beanfoodbackend.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE p.id IN :ids")
    List<Produto> findByIds(@Param("ids") List<Long> ids);
}
