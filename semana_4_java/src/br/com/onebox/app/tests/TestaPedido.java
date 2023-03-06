package br.com.onebox.app.tests;

import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.domain.Cliente;
import br.com.onebox.app.domain.Pedido;
import br.com.onebox.app.domain.Produto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestaPedido {
    public static void main(String[] args) {

        Categoria categoria1 = new Categoria(0, "INFORMÁTICA", Boolean.TRUE);
        Categoria categoria2 = new Categoria(1, "LIVROS", Boolean.FALSE);
        Categoria categoria3 = new Categoria(2, "ELETRÔNICOS", Boolean.TRUE);


        Produto produto1 = new Produto(1, "Notebook Samsung", "Informática", new BigDecimal("3523.00"), 1, categoria1);
        Produto produto2 = new Produto(2, "Clean Architecture", "Livros", new BigDecimal("102.90"), 2, categoria2);
        Produto produto3 = new Produto(3, "Monitor Dell 27", "Informática", new BigDecimal("1889.00"), 3, categoria3);

        Cliente cliente1 = new Cliente(1, "Kim", "Kardashian", "100.200.900-01", "11-95558-4221", "Rua das Flores", "90210", "Mansão", "OMelhor", "Los Angeles", "California");
        Cliente cliente2 = new Cliente(2, "Xuxa", "Meneghel", "001.205.585-02", "11-89958-4851", "Rua do Projac", "100", "Casa", "Jacarepaguá", "Rio de Janeiro", "Rio de Janeiro");
        Cliente cliente3 = new Cliente(3, "Elon", "Musk", "851.568.201-72", "13-98547-6953", "Rua da Starlink", "666", "Edifício", "Boca Chica", "Dallas", "Texas");

        Pedido pedido1 = new Pedido(cliente1, new BigDecimal("2500.00"), 1, LocalDate.now());
        Pedido pedido2 = new Pedido(cliente2, new BigDecimal("500.00"), 2, LocalDate.now());
        Pedido pedido3 = new Pedido(cliente3, new BigDecimal("2500.00"), 3, LocalDate.now());

        System.out.println("Informações dos Pedidos:");
        System.out.println(produto1.getNome() + ", " + pedido1.getCliente().getPrimeiroNome() + " " + pedido1.getCliente().getSobrenome() + ", " +
                pedido1.getPreco() + ", " + pedido1.getData());

        System.out.println(produto2.getNome() + ", " + pedido2.getCliente().getPrimeiroNome() + " " + pedido2.getCliente().getSobrenome() + ", " +
                pedido2.getPreco() + ", " + pedido2.getData());

        System.out.println(produto3.getNome() + ", " + pedido3.getCliente().getPrimeiroNome() + " " + pedido3.getCliente().getSobrenome() + ", " +
                pedido3.getPreco() + ", " + pedido3.getData());

    }


}
