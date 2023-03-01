package br.com.onebox.app.tests;

import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.domain.Produto;
import java.math.BigDecimal;

public class TestaProduto {

	public static void main(String[] args) 
	{
		Categoria categoria1 = new Categoria(0, "INFORMATICA", Boolean.TRUE);
        Categoria categoria2 = new Categoria(1, "MOVEIS", Boolean.FALSE);
        Categoria categoria3 = new Categoria(2, "LIVROS", Boolean.TRUE);
		
		
		Produto produto1 = new Produto (1, "Notebook Samsung", "Informatica", new BigDecimal("3523.00"), 1,categoria1);
		Produto produto2 = new Produto (2, "Clean Architecture", "Livros", new BigDecimal("102.90"), 2, categoria3);
		Produto produto3 = new Produto (3, "Monitor Dell 27","Informatica", new BigDecimal("1889.00"), 3, categoria1);

		System.out.println("-------Produto 1-------");
        System.out.println(produto1.toString());
        
        System.out.println("-------Produto 2-------");
        System.out.println(produto2.toString());
        
        System.out.println("-------Produto 3-------");
        System.out.println(produto3.toString());
        
        
        
	}

}
