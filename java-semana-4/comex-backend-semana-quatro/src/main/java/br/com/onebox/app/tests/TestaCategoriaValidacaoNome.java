package br.com.onebox.app.tests;

import br.com.onebox.app.domain.Categoria;

public class TestaCategoriaValidacaoNome {
    public static void main(String[] args) throws Exception {
        Categoria categoria1 = new Categoria("Informática");
        Categoria categoria2 = new Categoria("  ");
        Categoria categoria3 = new Categoria(null);

        System.out.println(categoria1);
        System.out.println(categoria2);
        System.out.println(categoria3);
    }
}
