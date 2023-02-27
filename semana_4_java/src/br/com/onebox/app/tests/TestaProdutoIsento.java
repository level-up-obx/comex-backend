package br.com.onebox.app.tests;

import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.domain.Produto;
import br.com.onebox.app.domain.ProdutoIsento;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestaProdutoIsento {
    public static void main(String[] args) {

        Categoria categoria1 = new Categoria(1, "SAÚDE", Boolean.TRUE);
        Categoria categoria2 = new Categoria(2, "LIVROS", Boolean.FALSE);
        Categoria categoria3 = new Categoria(3, "INFORMÁTICA", Boolean.TRUE);


        ProdutoIsento produto1 = new ProdutoIsento(1, "Vacina", "Vacina covid", new BigDecimal("250.00"), 1000, categoria1);
        ProdutoIsento produto2 = new ProdutoIsento(2, "Use a Cabeça: Java", "Livro: Use a Cabeça: Java", new BigDecimal("112.90"), 5, categoria2);
        Produto produto3 = new Produto(3, "Macbook Pro", "MacbookPro-computador", new BigDecimal("20000.00"), 11, categoria3);


        System.out.println("--------- PRODUTO - 1 VACINA ----------");
        System.out.println(produto1);
        System.out.println("Valor Total em Estoque: R$" + produto1.calculaValorTotalEstoque().setScale(2, RoundingMode.HALF_UP).toString());
        System.out.println("Imposto: R$" + produto1.calculaImposto(produto1.getPrecoUnitario()));
        System.out.println();

        System.out.println("--------- PRODUTO - 2 LIVRO JAVA----------");
        System.out.println(produto2);
        System.out.println("Valor Total em br.com.onebox.app.domain.Estoque: R$" + produto2.calculaValorTotalEstoque().setScale(2, RoundingMode.HALF_UP).toString());
        System.out.println("Imposto: R$" + produto2.calculaImposto(produto2.getPrecoUnitario()));
        System.out.println();

        System.out.println("--------- PRODUTO - 3 MACBOOK ----------");
        System.out.println(produto3);
        System.out.println("Valor Total em Estoque: R$" + produto3.calculaValorTotalEstoque().setScale(2, RoundingMode.HALF_UP).toString());
        System.out.println("Imposto: R$" + produto3.calculaImposto(produto3.getPrecoUnitario()));
        ;

    }
}