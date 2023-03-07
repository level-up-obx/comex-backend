package br.com.onebox.app.tests;

import br.com.onebox.app.domain.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestaPedidoOrdenado {
    public static void main(String[] args) {

        Categoria categoria1 = new Categoria(0, "INFORMÁTICA", Boolean.TRUE);
        Categoria categoria2 = new Categoria(1, "LIVROS", Boolean.FALSE);
        Categoria categoria3 = new Categoria(2, "MOVEIS", Boolean.TRUE);


        Produto produto1 = new Produto(1, "Notebook Samsung", "Informática", new BigDecimal("3523.00"), 1, categoria1);
        Produto produto2 = new Produto(2, "Clean Architecture", "Livros", new BigDecimal("102.90"), 2, categoria2);
        Produto produto3 = new Produto(3, "Mesa de Escritório", "Móvel", new BigDecimal("2000.00"), 3, categoria3);
        Produto produto4 = new Produto(4, "Cadeira de Escritório", "Móvel", new BigDecimal("500.00"), 3, categoria3);
        Produto produto5 = new Produto(5, "Monitor Samsung", "Informática", new BigDecimal("3500.00"), 3, categoria1);

        Cliente cliente1 = new Cliente(1, "Kim", "Kardashian", "100.200.900-01", "11-95558-4221", "Rua das Flores", "90210", "Mansão", "OMelhor", "Los Angeles", "California");
        Cliente cliente2 = new Cliente(2, "Xuxa", "Meneghel", "001.205.585-02", "11-89958-4851", "Rua do Projac", "100", "Casa", "Jacarepaguá", "Rio de Janeiro", "Rio de Janeiro");
        Cliente cliente3 = new Cliente(3, "Elon", "Musk", "851.568.201-72", "13-98547-6953", "Rua da Starlink", "666", "Edifício", "Boca Chica", "Dallas", "Texas");


        ArrayList<Pedido> pedidos = new ArrayList<>();
        pedidos.add(new Pedido(cliente1, new BigDecimal("3000.00"), 1, LocalDate.of(2021, 10, 28)));
        pedidos.add(new Pedido(cliente2, new BigDecimal("4000.00"), 2, LocalDate.of(2020, 11, 25)));
        pedidos.add(new Pedido(cliente2, new BigDecimal("200.00"), 5, LocalDate.of(2022, 12, 25)));
        pedidos.add(new Pedido(cliente3, new BigDecimal("1000.00"), 10, LocalDate.of(2023, 1, 8)));
        pedidos.add(new Pedido(cliente1, new BigDecimal("5000.00"), 20, LocalDate.of(2023, 2, 23)));


        System.out.println("------------------------------- ORDEM CRESCENTE ------------------------------------------------------");

        pedidos.sort(Comparator.comparing(Pedido::getValorTotal));
        pedidos.forEach(System.out::println);;

        System.out.println("------------------------------- ORDEM DECRESCENTE ----------------------------------------------------");

        pedidos.sort(Comparator.comparing(Pedido::getValorTotal).reversed());
        pedidos.forEach(System.out::println);

        System.out.println("-----------------------------------------------------------------------------------------");

        System.out.println("Pedido com Maior Valor Total: " + "\n" + pedidos.get(0));
        System.out.println("Pedido com Menor Valor Total: " + "\n" + pedidos.get(pedidos.size() - 1));


    }
}
