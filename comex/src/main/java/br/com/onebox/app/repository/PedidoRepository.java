package br.com.onebox.app.repository;

import br.com.onebox.app.domain.Pedido;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {

    public Iterable<Pedido> findAllByDate(LocalDate data);
}
