package br.com.onebox.app.service;

import br.com.onebox.app.domain.Produto;
import br.com.onebox.app.exceptions.ProdutoInvalidoException;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {
    List<Produto> produtos = new ArrayList<Produto>();

    public void cadastrar(Produto novoproduto) throws ProdutoInvalidoException {
        try {
            if (novoproduto.equals(null)) {
                throw new ProdutoInvalidoException("Produto inválido, produto nulo");
            }
            produtos.add(novoproduto);
            System.out.println("Produto cadastrado com sucesso!");
        } catch (ProdutoInvalidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public Produto get(Long id) throws ProdutoInvalidoException {
        try {
            if (id.equals(null) || id < 0) {
                throw new ProdutoInvalidoException("Produto inválido, id nulo ou menor que zero");
            }
        } catch (ProdutoInvalidoException e) {
            System.out.println(e.getMessage());
        }
        return produtos.stream()
                .findAny()
                .get();
    }
}
