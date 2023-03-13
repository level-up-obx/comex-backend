package br.com.onebox.app.service;

import br.com.onebox.app.exceptions.PrecoInvalidoException;
import br.com.onebox.app.domain.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoService {
    List<Produto> produtos = new ArrayList<>();
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
        produtos.add(novoProduto);
    }

    public Optional<Produto> get(int id) throws PrecoInvalidoException {
        if (id <= 0) throw new PrecoInvalidoException("ID não pode ser NEGATIVO ou NULO");
        return produtos.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }
}
