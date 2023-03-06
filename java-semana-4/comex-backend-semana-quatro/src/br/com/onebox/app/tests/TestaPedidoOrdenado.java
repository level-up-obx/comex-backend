package br.com.onebox.app.tests;
import br.com.onebox.app.domain.Cliente;
import br.com.onebox.app.domain.Pedido;
import br.com.onebox.app.domain.Produto;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestaPedidoOrdenado {
    public static void main(String[] args) throws Exception {
        Produto produto = new Produto("Notebook Samsung", new BigDecimal("3523.00"));

        Produto produto2 = new Produto("Clean Architeture", new BigDecimal("102.90"));

        Produto produto3 = new Produto("Monitor Dell 27", new BigDecimal("1889.00"));

        Produto produto4 = new Produto("Vacina", new BigDecimal("250.00"));

        Produto produto5 = new Produto("Use a Cabeça: Java", new BigDecimal("112.90"));

        Cliente cliente = new Cliente("João", "Orlando");

        Cliente cliente2 = new Cliente("Ricardo", "Ferreira");

        Cliente cliente3 = new Cliente("Fernando", "Junior");


        ArrayList<Pedido> pedidos = new ArrayList<>();
        pedidos.add(new Pedido(cliente, produto.getPrecoUnitario(),1, LocalDate.of(2023, 03, 06)));

        pedidos.add(new Pedido(cliente2, produto2.getPrecoUnitario(),2, LocalDate.of(2023, 03, 06)));

        pedidos.add(new Pedido(cliente3, produto3.getPrecoUnitario(),3, LocalDate.of(2023, 03, 06)));

        pedidos.add(new Pedido(cliente3, produto4.getPrecoUnitario(),3, LocalDate.of(2023, 03, 06)));

        pedidos.add(new Pedido(cliente2, produto5.getPrecoUnitario(),3, LocalDate.of(2023, 03, 06)));

        Comparator<Pedido> maisBarato = (pA, pB) -> pA.isMaisBaratoQue(pB) ? -1 : 1;
        Collections.sort(pedidos, maisBarato);
        System.out.println("Pedidos por valor total crescente:");
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }

        Comparator<Pedido> maisCaro = (pA, pB) -> pA.isMaisCaroQue(pB) ? -1 : 1;
        Collections.sort(pedidos, maisCaro);
        System.out.println("Pedidos por valor total decrescente:");
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }

    }
}
