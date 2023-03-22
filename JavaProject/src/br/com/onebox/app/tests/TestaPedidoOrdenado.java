package br.com.onebox.app.tests;

import br.com.onebox.app.domain.Pedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestaPedidoOrdenado {

    public static void main(String[] args) {

        Pedido pedido1 = new Pedido("Celular Sansung", "Tiago", 1500.0, 5, LocalDate.of(2022, 05, 12));
        Pedido pedido2 = new Pedido("Ventilador", "Jose", 70.0, 55, LocalDate.of(2022, 06, 01));
        Pedido pedido3 = new Pedido("Teclado", "Antonio", 25.0, 800, LocalDate.of(2023, 01, 12));
        Pedido pedido4 = new Pedido("Mouse", "Vanessa", 15.0, 1800, LocalDate.of(2022, 03, 25));
        Pedido pedido5 = new Pedido("Monitor 12 pol", "Claudia", 225.0, 300, LocalDate.of(2022, 03, 15));

        List<Pedido> lista = new ArrayList<>();
        lista.add(pedido1);
        lista.add(pedido2);
        lista.add(pedido3);
        lista.add(pedido4);
        lista.add(pedido5);

//        for (Pedido pedido : lista) {
//            System.out.println(pedido + "\n" + " Valor total : " + pedido.getValorTotal());
//
//        }

//        lista.forEach(System.out::println + "Valor Total :");

        Comparator.comparing(Pedido::getValorTotal);
        lista.sort(Comparator.comparing(Pedido::getValorTotal));
        lista.forEach((pedido -> System.out.println(pedido + "\n" + " Valor total : " + pedido.getValorTotal())));

        Collections.reverse(lista);

//        MaiorValorTotal comparator = new MaiorValorTotal();


        System.out.println("----------------------------------------- INVERSO --------------------------------------");

        lista.forEach((pedido -> System.out.println(pedido + "\n" + " Valor total : " + pedido.getValorTotal())));


//        for (Pedido pedido : lista) {
//            System.out.println(pedido + " \n " + " Valor total : " + pedido.getValorTotal());
//        }
//
//        lista.sort(comparator);


    }

}

//class MaiorValorTotal implements Comparator<Pedido> {
//
//    @Override
//    public int compare(Pedido pedido1, Pedido pedido2) {
//
//        return Double.compare(pedido1.getPreco(), pedido2.getPreco());
//
//
//    }







