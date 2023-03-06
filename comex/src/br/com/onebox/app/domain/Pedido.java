package br.com.onebox.app.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class Pedido {
    private Cliente cliente;
    private BigDecimal preco;
    private Integer quantidade;
    private LocalDateTime data;

    public Pedido(Cliente cliente, BigDecimal preco, Integer quantidade, LocalDateTime data) {
        this.cliente = cliente;
        this.preco = preco;
        this.quantidade = quantidade;
        this.data = data;
    }
    public Pedido(){

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

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public BigDecimal getValorTotal(){
        return this.preco.multiply(new BigDecimal(this.quantidade)).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return "Cliente = " + cliente.getPrimeiroNome() +
                ", Preco = " + getValorTotal() +
                ", Data = " + data;
    }
}
