package br.com.comex.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pedido {
	private Cliente cliente;
	private BigDecimal preco;
	private Long quantidade;
	private LocalDateTime data;
	
	public Pedido(
			Cliente cliente,
			BigDecimal preco,
			Long quantidade,
			LocalDateTime data
			) {
		this.setCliente(cliente);
		this.setPreco(preco);
		this.setQuantidade(quantidade);
		this.setData(data);
	}
	
	
	
	
	
	
	public Boolean isMaisBaratoQue(Pedido outroPedido) {
		return this.getValorTotal().compareTo(outroPedido.getPreco()) == -1 ;
	}

	public Boolean isMaisCaroQue(Pedido outroPedido) {
		return !this.isMaisBaratoQue(outroPedido);

	}

	public BigDecimal getValorTotal() {
		
		return preco.multiply(new BigDecimal(this.getQuantidade()));

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
	public Long getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}


}
