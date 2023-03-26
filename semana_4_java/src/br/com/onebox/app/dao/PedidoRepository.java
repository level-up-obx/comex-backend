package br.com.onebox.app.dao;
import java.util.Optional;
import br.com.onebox.app.domain.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

 Optional<Pedido> findById(Long id);

 Pedido save(Pedido pedido);
}