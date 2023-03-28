package br.com.onebox.app.repositories;
import java.util.Optional;
import br.com.onebox.app.domain.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

}