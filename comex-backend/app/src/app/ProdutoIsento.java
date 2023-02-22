package app;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProdutoIsento extends Produto {
	

	public ProdutoIsento(
			String nome,
			BigDecimal precoUnitario,
			Long quantidadeEstoque,
			Categoria categoria) {
		
		
		super( 
				nome,
				precoUnitario,
				quantidadeEstoque,
				categoria);
		super.setIsento(Boolean.TRUE);
	}
	
}
