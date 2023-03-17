package br.com.comex.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedidos {
	private Cliente cliente;
	private BigDecimal preco;
	private Integer quantidade;
	private LocalDate data;
	
	public Pedidos(
			Cliente cliente,
			BigDecimal preco,
			Integer quantidade,
			LocalDate data
			) {
		this.setCliente(cliente);
		this.setPreco(preco);
		this.setQuantidade(quantidade);
		this.setData(data);
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
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}


}
