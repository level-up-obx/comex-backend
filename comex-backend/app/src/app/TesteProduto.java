package app;

public class TesteProduto {
	public static void main(String[] args) {
		
		Categoria informatica =  new Categoria(1L, "INFORMÁTICA");
		
		Categoria moveis =  new Categoria(2L, "MÓVEIS");
		moveis.setStatus(Boolean.FALSE);
		
		Categoria livros =  new Categoria(3L, "LIVROS");
		
		Produto notebookSamsung = new Produto();
		notebookSamsung.setNome("Notebook Samsung");
		notebookSamsung.setPrecoUnitario(3523.00);
		notebookSamsung.setQuantidadeEstoque(1L);
		notebookSamsung.setCategoria(informatica);
		mostraResultado(notebookSamsung);
		
		Produto cleanArchitecture = new Produto();
		cleanArchitecture.setNome("Clean Architecture");
		cleanArchitecture.setPrecoUnitario(102.90);
		cleanArchitecture.setQuantidadeEstoque(2L);
		cleanArchitecture.setCategoria(livros);
		mostraResultado(cleanArchitecture);
		
		Produto monitorDell = new Produto();
		monitorDell.setNome("Monitor Dell 27");
		monitorDell.setPrecoUnitario(1889.00);
		monitorDell.setQuantidadeEstoque(3L);
		monitorDell.setCategoria(informatica);
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
