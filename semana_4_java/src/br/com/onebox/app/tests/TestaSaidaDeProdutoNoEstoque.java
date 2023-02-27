package br.com.onebox.app.tests;

import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.domain.Estoque;
import br.com.onebox.app.domain.ProdutoIsento;

import java.math.BigDecimal;

public class TestaSaidaDeProdutoNoEstoque {
    public static void main(String[] args) {

        Categoria categoria1 = new Categoria(1, "SAÚDE", Boolean.TRUE);
        ProdutoIsento produto1 = new ProdutoIsento(1, "Vacina", "Vacina Covid", new BigDecimal("250.00"), 500, categoria1);

        Estoque estoque = new Estoque(1000);

        estoque.registraEntrada(produto1);

        System.out.println("╔═══════════════════════════╗");
        System.out.println("║                  (ENTRADA)║");
        System.out.println(estoque);
        System.out.println();

        estoque.registraSaida(produto1);

        System.out.println("╔═══════════════════════════╗");
        System.out.println("║                   (SAIDA) ║");
        System.out.println(estoque);


    }
}
