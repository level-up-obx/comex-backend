package br.com.onebox.app.domain;

import java.math.BigDecimal;

public class Pedido {

    private static int id ;

    private String produto;

    private String cliente;
    private double preco;
    private int quantidade;
    private String data;

    public int getId() {
        return id;
    }


    public String getProduto() {
        return produto;
    }

    public String getCliente() {
        return cliente;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return " ---------- Pedido------------- "+ "\n" + ++id + " - " +
                "produto ='" + produto + '\'' +
                ", cliente ='" + cliente + '\'' +
                ", preco =" + preco +
                ", quantidade =" + quantidade +
                ", data ='" + data + '\'' ;
    }

    public Pedido(String produto, String cliente, double preco, int quantidade, String data) {

        this.cliente = cliente;
        this.preco = preco;
        this.quantidade = quantidade;
        this.data = data;
        this.produto = produto;


    }
    public static int pedidoid () {
        id = ++id;
        return ++id;

    }

    public boolean isMaisBaratoQue(Pedido outroPedido) {

    }

    public boolean isMaisCaroQue(Pedido outroPedido) {

        return false;
    }

    public BigDecimal getValorTotal() {

        return null;
    }
}
