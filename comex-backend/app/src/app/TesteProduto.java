package app;

public class TesteProduto {
	public static void main(String[] args) {
		
		Categoria informatica =  new Categoria(1L, "INFORMÁTICA");
		
		Categoria moveis =  new Categoria(2L, "MÓVEIS");
		moveis.setStatus(Boolean.FALSE);
		
		Categoria livros =  new Categoria(3L, "LIVROS");
		
		Produto notebookSamsung = new Produto();
		notebookSamsung.setId(1L);
		notebookSamsung.setNome("Notebook Samsung");
		notebookSamsung.setPrecoUnitario(3523.00);
		notebookSamsung.setQuantidadeEstoque(1L);
		notebookSamsung.setCategoria(informatica);
		mostraResultado(notebookSamsung);
		
		Produto cleanArchitecture = new Produto();
		cleanArchitecture.setId(2L);
		cleanArchitecture.setNome("Clean Architecture");
		cleanArchitecture.setPrecoUnitario(102.90);
		cleanArchitecture.setQuantidadeEstoque(2L);
		cleanArchitecture.setCategoria(livros);
		mostraResultado(cleanArchitecture);
		
		Produto monitorDell = new Produto();
		monitorDell.setId(3L);
		monitorDell.setNome("Monitor Dell 27");
		monitorDell.setPrecoUnitario(1889.00);
		monitorDell.setQuantidadeEstoque(3L);
		monitorDell.setCategoria(informatica);
		mostraResultado(monitorDell);
	}
	
	public static void mostraResultado(Produto produto) {
		System.out.println(produto.getId() + " " 
				+ produto.getNome() + " "
				+ produto.getPrecoUnitario() + " "
				+ produto.getQuantidadeEstoque() + " "
				+ produto.getCategoria().getNome() + " "
				);
	}
}
