package br.com.onebox.app.tests;

import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.domain.produtoIsento;
import java.math.BigDecimal;


public class TestaProdutoIsento {

	public static void main(String[] args) {
		
		Categoria categoria1 = new Categoria(0, "SAUDE", Boolean.TRUE);
        Categoria categoria2 = new Categoria(1, "LIVROS", Boolean.FALSE);
        Categoria categoria3 = new Categoria(2, "INFORMATICA", Boolean.TRUE);
        
        produtoIsento produto1 = new produtoIsento(1, "Vacina", "Vacina de gripe", new BigDecimal(250.00), 1000, categoria1);
        produtoIsento produto2 = new produtoIsento(2, "Use a Cabeca: Java", "Livro de programcao", new BigDecimal(112.00), 5, categoria2);
        produtoIsento produto3 = new produtoIsento(3, "Mackbook Pro", "Notebook ultima geracao", new BigDecimal(20000.00), 11, categoria3);

        System.out.println("-------Produto 1-------");
        System.out.println(produto1.toString());
        
        System.out.println("-------Produto 2 -------");
        System.out.println(produto2.toString());
        
        System.out.println("-------Produto 3-------");
        System.out.println(produto3.toString());
        
      }

}
