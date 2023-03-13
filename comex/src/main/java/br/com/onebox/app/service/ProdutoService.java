package br.com.onebox.app.service;

import br.com.onebox.app.domain.Produto;
import br.com.onebox.app.exceptions.ProdutoInvalidoException;

import java.util.ArrayList;
import java.util.List;

public class ProdutoService {
    List<Produto> produtos = new ArrayList<Produto>();

    public void cadastrar(Produto novoproduto) throws ProdutoInvalidoException {
        if(novoproduto.equals(null)){
            throw new ProdutoInvalidoException("Produto inválido, produto nulo");
        }
        produtos.add(novoproduto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public Produto get(Long id) throws ProdutoInvalidoException {
        if (id.equals(null) || id < 0){
            throw new ProdutoInvalidoException("Produto inválido, id nulo ou menor que zero");
        } return produtos.stream()
                .findAny()
                .get();
    }
}
