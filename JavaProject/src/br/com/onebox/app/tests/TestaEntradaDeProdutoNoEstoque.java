package br.com.onebox.app.tests;

import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.domain.Estoque;
import br.com.onebox.app.domain.ProdutoIsento;

public class TestaEntradaDeProdutoNoEstoque {

    public static void main(String[] args) throws Exception {

        Categoria categoria1 = new Categoria("SAÚDE", true);
        Categoria categoria2 = new Categoria("LIVROS", false);
        Categoria categoria3 = new Categoria("INFORMÁTICA", true);

        Estoque estoque1 = new Estoque();

        ProdutoIsento produto1 = new ProdutoIsento(1,"Vacina", "Primeira dose", 250.00, 500, "Saude");
        System.out.println(produto1);


        ProdutoIsento produto2 = new ProdutoIsento(2,"Use a cabeça", "E a pedra filosofal", 112.9, 5, "Livros");
        System.out.println(produto2);

        ProdutoIsento produto3 = new ProdutoIsento(3," Macbook Pro", "15 pol", 20000.0, 15, "Informática");
        System.out.println(produto3);

        estoque1.registraEntrada(produto1);
        estoque1.registraEntrada(produto2);
        estoque1.registraEntrada(produto3);

        System.out.println(estoque1);






    }
}

