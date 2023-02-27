package br.com.onebox.app.tests;

import br.com.onebox.app.domain.Categoria;

public class TestaCategoria {

    public static void main(String[] args) {

        Categoria categoria1 = new Categoria("Informática");
        Categoria categoria2 = new Categoria("Móveis", false);
        Categoria categoria3 = new Categoria("Livros");

        System.out.println(categoria1);
        System.out.println(categoria2);
        System.out.println(categoria3);

    }

}
