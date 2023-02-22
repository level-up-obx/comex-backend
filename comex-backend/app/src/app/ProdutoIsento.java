package app;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProdutoIsento {

	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal preco_unitario;
	private Long quantidade_estoque;
	private String categoria;
	
	public BigDecimal calculaValorTotalEmEstoque() {
		return new BigDecimal(quantidade_estoque).multiply(preco_unitario.setScale(0, RoundingMode.HALF_UP));
	}
	
	public BigDecimal calculaImpostoo() {
		return BigDecimal.ZERO;
	}

}
