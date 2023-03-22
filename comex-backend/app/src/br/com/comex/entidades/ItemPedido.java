package br.com.comex.entidades;

import java.math.BigDecimal;

import br.com.comex.enums.TipoDescontoProdutoEnum;

public class ItemPedido {

	private Produto produto;
	private Pedido pedido;
	private BigDecimal precoUnitario;
	private int quantidade;
	private BigDecimal desconto;
	private TipoDescontoProdutoEnum tipoDesconto;
	
	public BigDecimal getTotal(Pedido pedido){
		return getPrecoUnitarioTotal().multiply(new BigDecimal(quantidade));
	}
	
	public BigDecimal getPrecoUnitarioTotal() {
		if(desconto.compareTo(BigDecimal.ZERO) > 1) {
			return this.precoUnitario.multiply(desconto);
		}else {
			return this.precoUnitario;
		}
	}
}
