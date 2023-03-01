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
        System.out.println("Nome: " + produto1.getNome());
        System.out.println("Categoria: " + produto1.getCategoria());
        System.out.println("Preco unitario: R$ " + produto1.getPrecoUnitario());
        System.out.println("Quantidade em Estoque: " + produto1.getQuantidadeEstoque());
        System.out.println("Valor Total em Estoque: R$  " + produto1.ValorTotalEstoque(produto1.getPrecoUnitario(), 
        		produto1.getQuantidadeEstoque()));
        System.out.println("Valor imposto: R$ " + produto1.ImpostoIsento());
        
        System.out.println();
        
        System.out.println("-------Produto 2-------");
        System.out.println("Nome: " + produto2.getNome());
        System.out.println("Categoria: " + produto2.getCategoria());
        System.out.println("Preco unitario: R$ " + produto2.getPrecoUnitario());
        System.out.println("Quantidade em Estoque: " + produto2.getQuantidadeEstoque());
        System.out.println("Valor Total em Estoque: R$ " + produto2.ValorTotalEstoque(produto2.getPrecoUnitario(), 
        		produto2.getQuantidadeEstoque()));
        System.out.println("Valor imposto: R$  " + produto2.ImpostoIsento());
        
        System.out.println();
        
        System.out.println("-------Produto 3-------");
        System.out.println("Nome: " + produto3.getNome());
        System.out.println("Categoria: " + produto3.getCategoria());
        System.out.println("Preco unitario: R$ " + produto3.getPrecoUnitario());
        System.out.println("Quantidade em Estoque: " + produto3.getQuantidadeEstoque());
        System.out.println("Valor Total em Estoque: R$ " + produto3.ValorTotalEstoque(produto3.getPrecoUnitario(), produto3.getQuantidadeEstoque()));
        System.out.println("Valor imposto: R$ " + produto3.CalculaImposto(produto3.getPrecoUnitario()));
        
        
        
	}

}
