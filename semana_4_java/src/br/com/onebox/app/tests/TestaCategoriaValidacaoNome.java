package br.com.onebox.app.tests;

import br.com.onebox.app.CategoriaInvalidaException;
import br.com.onebox.app.domain.Categoria;


public class TestaCategoriaValidacaoNome {
    public static void main(String[] args) {
        Categoria categoria1 = new Categoria(1, "INFORMATICA", Boolean.TRUE);

        System.out.println(categoria1.getNome());

        try {
            Categoria categoria2 = new Categoria(2, "", Boolean.TRUE);
        } catch (CategoriaInvalidaException msg) {
            System.out.println("MSG: " + msg.getMessage());
        }
        try {
            Categoria categoria3 = new Categoria(3, null, Boolean.TRUE);
        } catch (CategoriaInvalidaException msg) {
            System.out.println("MSG: " + msg.getMessage());
        }


    }
}
