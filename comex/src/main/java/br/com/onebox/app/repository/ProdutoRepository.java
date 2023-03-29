package br.com.onebox.app.repository;

import br.com.onebox.app.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE p.quantidadeEmEstoque = 0")
    public List<Produto> findUnavailableProducts();

    @Query("SELECT p FROM Produto p ORDER BY p.nome DESC")
    List<Produto> listProductsByNamePageable();
}
