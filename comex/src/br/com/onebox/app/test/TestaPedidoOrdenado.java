package br.com.onebox.app.test;

import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.domain.Cliente;
import br.com.onebox.app.domain.Pedido;
import br.com.onebox.app.domain.Produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestaPedidoOrdenado {
    public static void main(String[] args) {

        Produto macbook = new Produto(1L, "Macbook Pro", new BigDecimal("20000.00"), 11, new Categoria("Informática"));
        Produto cleanArchitecture = new Produto(2L, "Clean Architecture", new BigDecimal("100.00"), 25, new Categoria("Livros"));
        Produto mesa4Lugares = new Produto(3L, "Mesa 4 Lugares", new BigDecimal("564.00"), 4, new Categoria("Móveis"));

        Pedido pedido1 = new Pedido(new Cliente("Marcelo"), new BigDecimal("20000.00"), 1, LocalDateTime.now());
        Pedido pedido2 = new Pedido(new Cliente("Joana"), new BigDecimal("100.00"), 6, LocalDateTime.now());
        Pedido pedido3 = new Pedido(new Cliente("Felipe"), new BigDecimal("564.00"), 9, LocalDateTime.now());
        Pedido pedido4 = new Pedido(new Cliente("Ivone"), new BigDecimal("100.00"), 12, LocalDateTime.now());
        Pedido pedido5 = new Pedido(new Cliente("Paula"), new BigDecimal("564.00"), 1, LocalDateTime.now());

        List<Pedido> pedidos = new ArrayList<Pedido>();
        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);
        pedidos.add(pedido4);
        pedidos.add(pedido5);

        pedidos.sort(Comparator.comparing(Pedido::getValorTotal));
        pedidos.forEach(System.out::println);

        System.out.println("INVERTENDO A ORDEM");
        System.out.println("-".repeat(60));

        pedidos.sort(Comparator.comparing(Pedido::getValorTotal).reversed());
        pedidos.forEach(System.out::println);


    }
}
