package main.java.br.com.comex.services;

import main.java.br.com.comex.entidades.Produto;

public class ProdutoService {

	public void cadastrar(Produto novoProduto){

	}

	public Produto getProdutoById(Long id) {
		if(id.equals(null))
			throw new RuntimeException("Para buscar um produto, precisa de um id válido");

		return null;
	}
}

