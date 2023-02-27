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
        System.out.println("║  Dados do Estoque (ENTRADA)║");
        System.out.printf("║ Capacidade     │ %8d  ║\n", estoque.getCapacidade());
        System.out.printf("║ Ocupação       │ %8d  ║\n", estoque.getOcupacao());
        System.out.println("╟────────────────┼────────-─-╢");
        System.out.println();

        estoque.registraSaida(produto1);

        System.out.println("╔═══════════════════════════╗");
        System.out.println("║  Dados do Estoque (SAIDA) ║");
        System.out.println("╟────────────────┬─────────-─╢");
        System.out.printf("║ Capacidade     │ %8d  ║\n", estoque.getCapacidade());
        System.out.printf("║ Ocupação       │ %8d  ║\n", estoque.getOcupacao());
        System.out.println("╟────────────────┼────────-─-╢");


    }
}
