package com.onebox_comex.repository;

import com.onebox_comex.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findAll();
    @Query("SELECT p FROM Pedido p WHERE p.data = :data")
    List<Pedido> buscaPorData(@Param("data") LocalDate data);

}
