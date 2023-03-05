package br.com.onebox.app.tests;

import br.com.onebox.app.domain.Pedido;

public class TestaPedido {

    public static void main(String[] args) {
        Pedido pedido1 = new Pedido("Celular Sansung", "Carlos", 1000.0, 23, "04/03/23");
        System.out.println(pedido1);

        Pedido pedido2 = new Pedido("Ventilador", "Jose", 100.0, 12, "02/03/23");
        System.out.println(pedido2);

        Pedido pedido3 = new Pedido("Teclado Mecânico", "Heitor", 250.0, 10, "01/01/23");
        System.out.println(pedido3);


    }

}
