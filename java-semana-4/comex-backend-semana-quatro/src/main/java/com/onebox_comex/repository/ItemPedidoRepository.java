package com.onebox_comex.repository;

import com.onebox_comex.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
    @Query("SELECT SUM(ip.quantidade) FROM ItemPedido ip WHERE ip.produto.categoria.id = :categoriaId")
    Long countQuantidadeProdutosPorCategoria(@Param("categoriaId") Long categoriaId);

    @Query("SELECT SUM(ip.quantidade * ip.preco) FROM ItemPedido ip WHERE ip.produto.categoria.id = :categoriaId")
    BigDecimal sumMontanteVendidoPorCategoria(@Param("categoriaId") Long categoriaId);
}

