package br.com.onebox.app.repository;

import br.com.onebox.app.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    public List<Pedido> findAllByData(LocalDate data);
}
