package br.com.onebox.app.tests;

import br.com.onebox.app.domain.Cliente;

public class TestaCliente {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1, "Kim", "Kardashian", "100.200.900-01", "11-95558-4221", "Rua das Flores", "90210", "Mansão", "OMelhor", "Los Angeles", "California" );
        Cliente cliente2 = new Cliente(2, "Xuxa", "Meneghel", "001.205.585-02", "11-89958-4851", "Rua do Projac", "100", "Casa", "Jacarepaguá", "Rio de Janeiro", "Rio de Janeiro" );
        Cliente cliente3 = new Cliente(3, "Elon", "Musk", "851.568.201-72", "13-98547-6953", "Rua da Starlink", "666", "Edifício", "Boca Chica", "Dallas", "Texas" );


        System.out.println("--------- CLIENTE 1 ----------");
        System.out.println(cliente1.toString());

        System.out.println("--------- CLIENTE 2 ----------");
        System.out.println(cliente2.toString());

        System.out.println("--------- CLIENTE 3 ----------");
        System.out.println(cliente3.toString());

    }



}
