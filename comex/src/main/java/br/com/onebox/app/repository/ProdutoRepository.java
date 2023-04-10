package br.com.onebox.app.repository;

import br.com.onebox.app.api.produto.ProdutoDto;
import br.com.onebox.app.domain.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long>, CrudRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE p.quantidadeEmEstoque = 0")
    public List<Produto> findUnavailableProducts();

    @Query("SELECT p.categoria AS categoria, SUM(i.quantidade) AS quantidade_vendida, SUM(i.quantidade * i.precoUnitario) AS montante_vendido FROM Pedido pe JOIN pe.itens i JOIN i.produto p GROUP BY p.categoria")
    public List<Object> relatorioDeVendasPorCategoria();
}
