package br.com.onebox.app.tests;

import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.domain.Produto;

import java.math.BigDecimal;

public class TestaProduto {

    public static void main(String[] args) {
        Categoria categoria4 = new Categoria("INFORMÁTICA");
        Categoria categoria5 = new Categoria("LIVROS");
        Produto produto1 = new Produto("Notebook Samsung", new BigDecimal("3523.00"), 1, categoria4);
        Produto produto2 = new Produto("Clean Architeture", new BigDecimal("102.90"), 2, categoria5);
        Produto produto3 = new Produto("Monitor Dell 27", new BigDecimal("1889.00"), 3, categoria4);

        System.out.println(produto1 + "\n" + " e categoria: " + categoria4.getNome() + "." + "\n");
        System.out.println(produto2 + "\n" + " e categoria: " + categoria5.getNome() + "." + "\n");
        System.out.println(produto3 + "\n" + " e categoria: " + categoria4.getNome() + "." + "\n");

    }

}
