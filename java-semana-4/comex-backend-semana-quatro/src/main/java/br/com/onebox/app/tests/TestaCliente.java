package br.com.onebox.app.tests;

import br.com.onebox.app.domain.Cliente;

public class TestaCliente {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("João", "Orlando", "333.333.333-33",
                "+5511958023432" + "\n");
        Cliente cliente2 = new Cliente("Gustavo", "Ferreira", "222.222.222-22",
                "+5511957022431" + "\n");
        Cliente cliente3 = new Cliente("Fernando", "Junior", "444.444.444-43",
                "+5511942013432" + "\n");

        System.out.println(cliente1);
        System.out.println(cliente2);
        System.out.println(cliente3);
    }

}
