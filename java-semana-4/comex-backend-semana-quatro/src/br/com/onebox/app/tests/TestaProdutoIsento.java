package br.com.onebox.app.tests;

import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.domain.Produto;
import br.com.onebox.app.domain.ProdutoIsento;

import java.math.BigDecimal;

public class TestaProdutoIsento {
    public static void main(String[] args) throws Exception {

        Categoria categoria1 = new Categoria("Saúde");
        Categoria categoria2 = new Categoria("Livros");
        Categoria categoria3 = new Categoria("Informática");
        ProdutoIsento produtoIsento1 = new ProdutoIsento("Vacina", new BigDecimal("250.00"), 1000, categoria1 );
        ProdutoIsento produtoIsento2 = new ProdutoIsento("Use a Cabeça: Java", new BigDecimal("112.90"), 5, categoria2);
        Produto produto3 = new Produto("Macbook Pro", new BigDecimal("20000.00"), 11, categoria3);

        System.out.println(produtoIsento1 + " e categoria: " + categoria1.getNome() + "." + "\n");
        System.out.println(produtoIsento2 + " e categoria: " + categoria2.getNome() + "." + "\n");
        System.out.println(produto3 + " e categoria: " + categoria3.getNome() + "." + "\n");

    }

}
