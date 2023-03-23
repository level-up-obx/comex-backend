package br.com.onebox.app.repository;

import br.com.onebox.app.domain.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE p.quantidadeEmEstoque = 0")
    public Iterable<Produto> findUnavailableProducts();
}
