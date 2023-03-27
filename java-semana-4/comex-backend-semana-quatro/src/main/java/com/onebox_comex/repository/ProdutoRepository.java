package com.onebox_comex.repository;

import com.onebox_comex.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
   List<Produto> findAll();
   @Query("SELECT p FROM Produto p WHERE p.quantidadeEmEstoque = 0")
   List<Produto> listaIndisponiveis(@Param("quantidadeEmEstoque") int quantidadeEmEstoque);

}
