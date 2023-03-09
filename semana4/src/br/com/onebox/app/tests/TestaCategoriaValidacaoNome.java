package br.com.onebox.app.tests;

import br.com.onebox.app.domain.CategoriaInvalidaException;
import br.com.onebox.app.domain.Categoria;

public class TestaCategoriaValidacaoNome {

	public static void main(String[] args) {
		
		Categoria categoria1 = new Categoria(1, "LIVROS", Boolean.TRUE);
		System.out.println("--Categoria 1--");
		System.out.println("Categoria: " + categoria1.getNome());
		
		try {
            Categoria categoria2 = new Categoria(2, " ", Boolean.TRUE);
        } catch (CategoriaInvalidaException msg) {
        	System.out.println("--Categoria 2--");
            System.out.println("Mensagem: " + msg.getMessage());
        }
        try {
            Categoria categoria3 = new Categoria(3, null, Boolean.TRUE);
        } catch (CategoriaInvalidaException msg) {
        	System.out.println("--Categoria 3--");
            System.out.println("Mensagem: " + msg.getMessage());
        }

	}

}
