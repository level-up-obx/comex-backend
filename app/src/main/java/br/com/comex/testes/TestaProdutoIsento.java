package br.com.comex.testes;

import java.math.BigDecimal;

import br.com.comex.entidades.Categoria;
import br.com.comex.entidades.Produto;
import br.com.comex.entidades.ProdutoIsento;

public class TestaProdutoIsento {

	public static void main(String[] args) throws Exception {
		Categoria informatica =  new Categoria(1L, "INFORMÁTICA");
		
		Categoria moveis =  new Categoria(2L, "MÓVEIS");
		moveis.setStatus(Boolean.FALSE);
		
		Categoria livros =  new Categoria(3L, "LIVROS");
		
		Categoria saude =  new Categoria(3L, "SAUDE");
		
		Produto vacina = new ProdutoIsento("Vacina",new BigDecimal(250.00), 1000L, saude);
		mostraResultadoIsento(vacina);
		
		Produto java = new ProdutoIsento("Java",new BigDecimal(112.90), 5L, livros);
		mostraResultadoIsento(java);
		
		Produto macBookPro = new Produto("Java",new BigDecimal(20000.00), 11L, informatica);
		mostraResultadoIsento(macBookPro);
	}
	
	public static void mostraResultadoIsento(Produto produto) {
		System.out.println("");
		System.out.println("Buscando...");
		System.out.println("----------------");
		System.out.println("Produto ID: " + produto.getId() + " -> " + produto.getNome());
		System.out.println("Preço unitário: " + produto.getPrecoUnitario());
		System.out.println("Valor de imposto: R$ " + produto.calculaImposto());
		System.out.println("Qnt Estoque: " + produto.getQuantidadeEstoque());
		System.out.println("Valor total do estoque: R$ " + produto.valorTotalEstoque());
		System.out.println("Categoria: " + produto.getCategoria().getNome());
		System.out.println("----------------");

	}

}
