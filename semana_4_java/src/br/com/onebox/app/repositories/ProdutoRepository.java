package br.com.onebox.app.repositories;


import br.com.onebox.app.domain.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
    List<Produto> findByQuantidadeEstoque(int quantidadeEstoque);
}