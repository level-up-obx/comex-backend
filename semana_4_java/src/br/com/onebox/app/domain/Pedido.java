package br.com.onebox.app.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {
    private Categoria categoria;
    private Produto produto;
    private Cliente cliente;
    private BigDecimal preco;
    private int quantidade;
    private LocalDate data;

    public Pedido (Produto produto, Cliente cliente, BigDecimal preco, int quantidade, LocalDate data) {
        this.categoria = categoria;
        this.produto = produto;
        this.cliente = cliente;
        this.preco = preco;
        this.quantidade = quantidade;
        this.data = data;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
        return "Pedido" +
                "\n"+ "Produto:" + produto.getNome() +
                "\n"+" Cliente:" + cliente.getPrimeiroNome() +
                "\n"+" Preco:" + preco +
                "\n"+" Valor Total:" + getValorTotal() +
                "\n"+" Data:" + data + "\n";
    }

}
