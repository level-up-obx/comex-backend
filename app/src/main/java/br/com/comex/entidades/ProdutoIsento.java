package br.com.comex.entidades;

import java.math.BigDecimal;

public class ProdutoIsento extends Produto {


	public ProdutoIsento(
			String nome,
			BigDecimal precoUnitario,
			Long quantidadeEstoque,
			br.com.comex.entity.Categoria Categoria) throws Exception {


		super(
				nome,
				precoUnitario,
				quantidadeEstoque,
				Categoria);
		super.setIsento(Boolean.TRUE);
	}

}
