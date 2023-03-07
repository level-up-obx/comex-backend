package br.com.onebox.app.domain;


import java.math.BigDecimal;

public class Estoque {

	private int capacidade = 1000;
	private int ocupacao;
	private BigDecimal montante = BigDecimal.ZERO;

	
	public Estoque(int capacidade) {
		this.capacidade = capacidade;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public int getOcupacao() {
		return ocupacao;
	}
	public BigDecimal getMontante() {
		return montante;
	}
	
	public void registraEntrada(Produto produto)
	{
		if (produto.getQuantidadeEstoque() > 0) {
            int quantidade = produto.getQuantidadeEstoque();
            if (ocupacao + quantidade > capacidade) {
                System.out.println("Estoque cheio");
                return;
            }
            ocupacao = ocupacao + quantidade;
            montante = montante.add(produto.ValorTotalEstoque(montante, quantidade));
        }
		
	}
	
	public void registraSaida(Produto produto)
	{
		
		if (produto.getQuantidadeEstoque() > 0) {
            int quantidade = produto.getQuantidadeEstoque();
            ocupacao = ocupacao + quantidade;
            if (ocupacao - quantidade < capacidade) {
                System.out.println("Estoque insuficiente");
                return;
            }
            
            montante = montante.subtract(produto.ValorTotalEstoque(montante, quantidade));
        }
    }
	
	
}
