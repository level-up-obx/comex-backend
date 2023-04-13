package br.com.onebox.app.repository;

import br.com.onebox.app.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long>, CrudRepository<Pedido,Long> {

    public List<Pedido> findAllByData(LocalDate data);

    @Query("SELECT COUNT(p) FROM Pedido p WHERE p.cliente.id = :clienteId")
    public Integer contaPedidosPeloClienteId(@Param("clienteId") Long clienteId);
}
