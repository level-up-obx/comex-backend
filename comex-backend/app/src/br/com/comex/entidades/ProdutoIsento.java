package br.com.comex.entidades;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProdutoIsento extends Produto {
	

	public ProdutoIsento(
			String nome,
			BigDecimal precoUnitario,
			Long quantidadeEstoque,
			Categoria categoria) throws Exception {
		
		
		super( 
				nome,
				precoUnitario,
				quantidadeEstoque,
				categoria);
		super.setIsento(Boolean.TRUE);
	}
	
}
