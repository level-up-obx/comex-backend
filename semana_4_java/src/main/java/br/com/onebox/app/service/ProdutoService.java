package br.com.onebox.app.service;

import br.com.onebox.app.exceptions.PrecoInvalidoException;
import br.com.onebox.app.entity.Produto;
import br.com.onebox.app.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;

@Service
public class ProdutoService {

    @Autowired
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void cadastrar(Produto novoProduto) throws PrecoInvalidoException {
        if (novoProduto == null) {
            throw new PrecoInvalidoException("Produto não pode ser NULO.");
        }
        if (novoProduto.getNome() == null || novoProduto.getNome().trim().isEmpty()) {
            throw new PrecoInvalidoException("Nome não pode ser VAZIO ou NULO.");
        }
        if (novoProduto.getPrecoUnitario() == null || novoProduto.getPrecoUnitario().compareTo(BigDecimal.ZERO) <= 0) {
            throw new PrecoInvalidoException("Preço inválido! O Preço deve ser maior que zero.");
        }
        produtoRepository.save(novoProduto);
    }
}
