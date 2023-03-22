package br.com.onebox.app.tests;

import br.com.onebox.app.domain.Pedido;

import java.time.LocalDate;

public class TestaPedido {

    public static void main(String[] args) {
        Pedido pedido1 = new Pedido("Celular Sansung", "Carlos", 1000.0, 23, LocalDate.of(2023,04,03));
        System.out.println(pedido1);

        Pedido pedido2 = new Pedido("Ventilador", "Jose", 100.0, 12, LocalDate.of(2023, 03,02));
        System.out.println(pedido2);

        Pedido pedido3 = new Pedido("Teclado Mecânico", "Heitor", 250.0, 10, LocalDate.of(2023,01,01));
        System.out.println(pedido3);


    }

}
