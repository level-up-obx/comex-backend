package br.com.onebox.app.domain;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Pedido {

	private Cliente cliente;
	private BigDecimal preco;
	private int quantidade;
	private LocalDate data;
	
	public Pedido(Cliente cliente, BigDecimal preco, int quantidade, LocalDate data ) {
		
		this.cliente = cliente;
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
		
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public boolean isMaisBaratoQue(Pedido outroPedido) {
        
		return preco.compareTo(outroPedido.getPreco()) < 0;
		
	}

	public boolean isMaisCaroQue(Pedido outroPedido) {
       
		return preco.compareTo(outroPedido.getPreco()) > 0;
	}

	public BigDecimal getValorTotal() {

		return preco.multiply(BigDecimal.valueOf(quantidade));
	}

	@Override
    public String toString() {
        return  "\n" + "Cliente: " + cliente.nomeCompleto() +"\n"
                +"Preco: R$" + preco + "\n" +
        		"Valor total: R$" + getValorTotal() + "\n"
                + "Data: " + data + "\n";
    }
}
