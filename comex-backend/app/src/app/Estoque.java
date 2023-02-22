package app;

import java.math.BigDecimal;

public class Estoque {

	private Long capacidade = 1000L;
	private Long ocupacao = 0L;
	private BigDecimal montante = BigDecimal.ZERO;
	
	
	public void registraEntrada(Produto produto) {
		System.out.println("montatnede:: inicial=R$  " + this.montante + "  A capacidade:: inicial   " + this.capacidade + " tal do estoque:" + this.ocupacao);
		
		
		setOcupacao(produto.getQuantidadeEstoque());
		setCapacidade(produto.getQuantidadeEstoque());
		setMontante(produto.valorTotalEstoque());
	}
	
	public void registraSaida(Produto produto) {
		setCapacidade(produto.getQuantidadeEstoque());
		setOcupacao(this.ocupacao - produto.getQuantidadeEstoque());
		setMontante(produto.getPrecoUnitario()
				.multiply(new BigDecimal(produto.getQuantidadeEstoque())));
	}
	
	private void setCapacidade(Long produtoEmEstoque) {
		this.capacidade -= produtoEmEstoque;
	}

	private void setOcupacao(Long ocupacaoIncremento) {
		this.ocupacao += ocupacaoIncremento;
	}

	private void setMontante(BigDecimal montantes) {
		this.montante = this.montante.add(montantes);
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
