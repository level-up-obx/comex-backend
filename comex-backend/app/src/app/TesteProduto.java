package app;

import java.math.BigDecimal;

public class TesteProduto {
	public static void main(String[] args) {
		
		Categoria informatica =  new Categoria(1L, "INFORMÁTICA");
		
		Categoria moveis =  new Categoria(2L, "MÓVEIS");
		moveis.setStatus(Boolean.FALSE);
		
		Categoria livros =  new Categoria(3L, "LIVROS");
		
		Produto notebookSamsung = new Produto("Notebook Samsung", new BigDecimal(3523.00), 1L, informatica);
		mostraResultado(notebookSamsung);
		
		Produto cleanArchitecture = new Produto("Clean Architecture", new BigDecimal(102.90), 2L, livros);
		mostraResultado(cleanArchitecture);
		
		Produto monitorDell = new Produto("Monitor Dell 27", new BigDecimal(1889.00), 3L, informatica);

		mostraResultado(monitorDell);
	}
	
	public static void mostraResultado(Produto produto) {
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
