package br.com.onebox.app.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {

    private static int id ;

    private String produto;

    private String cliente;
    private double preco;
    private int quantidade;
   private LocalDate data;

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

//    public LocalDate getData() {
//        return data;
//    }

    @Override
    public String toString() {
        return " ---------- Pedido------------- "+ "\n" + ++id + " - " +
                "produto = " + produto +
                " - cliente = " + cliente +
                " - preco = " + preco +
                " - data = " + data +
                " - quantidade = " + quantidade +
                 '\'' ;
    }


    public Pedido(String produto, String cliente, double preco, int quantidade, LocalDate data) {

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
//        if(quantidade * preco >= )

        return false;
    }

    public boolean isMaisCaroQue(Pedido outroPedido) {

        return false;
    }

    public BigDecimal getValorTotal() {
        BigDecimal valortotal = BigDecimal.valueOf(quantidade * preco);
        return valortotal;
        }
    }

