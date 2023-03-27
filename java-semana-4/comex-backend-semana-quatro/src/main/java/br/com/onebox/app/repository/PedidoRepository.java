package br.com.onebox.app.repository;

import br.com.onebox.app.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findAll();
    @Query("SELECT p FROM Pedido p WHERE p.data = :data")
    List<Pedido> buscaPorData(@Param("data") LocalDate data);

}
