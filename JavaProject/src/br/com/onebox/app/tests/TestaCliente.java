package br.com.onebox.app.tests;

import br.com.onebox.app.domain.Cliente;

public class TestaCliente {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Tiago", "Augusto Seixas", "091.310" +
                "091.358.666.99","(12) 98823-3542", "Geraldo Machado Silva", "427", " ",
                "Vila Unidos", "São José dos Campos", "São Paulo");

        System.out.println(cliente1);


        Cliente cliente2 = new Cliente("Juan", "Santos Martins", "424.555.898.x",
                "(12) 98844-5130", "Rubião Junior", "424", "ap 12 bl 5", "Centro",
                "Taubaté", "São Paulo");


        System.out.println( cliente2);


        Cliente cliente3 = new Cliente("Mayara","Taiane", "081.312.108.60","12 98823-3542",
                "José Antonio de Oliveira",  "417"," ", "Vila Unidos",
                "São José dos Campos", "São Paulo" );


        System.out.println(cliente3);

    }
}
