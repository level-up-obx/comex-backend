package br.com.onebox.app.repositories;


import br.com.onebox.app.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByQuantidadeEstoque(int quantidadeEstoque);
    Page<Produto> findAll(Pageable pageable);
}