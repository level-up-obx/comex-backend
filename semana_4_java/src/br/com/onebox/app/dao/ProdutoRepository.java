package br.com.onebox.app.dao;


import br.com.onebox.app.domain.Pedido;
import br.com.onebox.app.domain.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
    Optional<Produto> findById(Long id);
    List<Produto> findByQuantidadeEstoque(int quantidadeEstoque);

}