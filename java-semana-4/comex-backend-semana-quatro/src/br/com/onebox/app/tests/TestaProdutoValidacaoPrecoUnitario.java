package br.com.onebox.app.tests;

import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.domain.Produto;

import java.math.BigDecimal;

public class TestaProdutoValidacaoPrecoUnitario {
    public static void main(String[] args) {
        Categoria categoria4 = new Categoria("Saúde");
        Categoria categoria5 = new Categoria("Informática");
        Produto produto1 = new Produto("Vacina", new BigDecimal("250.00"), 1000, categoria4);
        Produto produto2 = new Produto("Macbook Pro", new BigDecimal("00.00"), 11, categoria5);

        System.out.println(produto1 + "\n" + " e categoria: " + categoria4.getNome() + "." + "\n");
        System.out.println(produto2 + "\n" + " e categoria: " + categoria5.getNome() + "." + "\n");
    }
}
