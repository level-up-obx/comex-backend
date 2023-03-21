package br.com.comex.entidades;

import java.math.BigDecimal;

public class Estoque {

	private Long capacidade = 1000L;
	private Long ocupacao = 0L;
	private BigDecimal montante = BigDecimal.ZERO;


	public void registraEntrada(Produto produto) {
		System.out.println("montatnede:: inicial=R$  " + this.montante + "  A capacidade:: inicial   " + this.capacidade + " tal do estoque:" + this.ocupacao);


		this.capacidade -= produto.getQuantidadeEstoque();
		this.ocupacao += produto.getQuantidadeEstoque();
		this.montante = this.montante.add(produto.valorTotalEstoque());
	}

	public void registraSaida(Produto produto) {
		this.capacidade += produto.getQuantidadeEstoque();
		this.ocupacao -= produto.getQuantidadeEstoque();
		this.montante = this.montante.subtract(produto.valorTotalEstoque());
	}


	public Long getCapacidade() {
		return capacidade;
	}
	public Long getOcupacao() {
		return ocupacao;
	}
	public BigDecimal getMontante() {
		return montante;
	}


}
