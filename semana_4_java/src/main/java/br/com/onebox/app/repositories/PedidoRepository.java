package br.com.onebox.app.repositories;
import br.com.onebox.app.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Query("SELECT COUNT(p) FROM Pedido p WHERE p.cliente.id = :clienteId")
    int countPedidosByClienteId(@Param("clienteId") Long clienteId);
}