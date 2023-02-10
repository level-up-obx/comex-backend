package app;

public class TesteProduto {
	public static void main(String[] args) {
		
		Categoria informatica =  new Categoria();
		informatica.setId(1L);
		informatica.setNome("INFORMÁTICA");
		
		Categoria moveis =  new Categoria();
		moveis.setId(2L);
		moveis.setNome("MÓVEIS");
		moveis.setStatus("INVATIVA");
		
		Categoria livros =  new Categoria();
		livros.setId(3L);
		livros.setNome("LIVROS");
		
		Produto notebookSamsung = new Produto();
		notebookSamsung.setId(1L);
		notebookSamsung.setNome("Notebook Samsung");
		notebookSamsung.setPrecoUnitario(3523.00);
		notebookSamsung.setQuantidadeEstoque(1L);
		notebookSamsung.setCategoria(informatica);
		System.out.println(notebookSamsung.getId() + " " 
				+ notebookSamsung.getNome() + " "
				+ notebookSamsung.getPrecoUnitario() + " "
				+ notebookSamsung.getQuantidadeEstoque() + " "
				+ notebookSamsung.getCategoria().getNome() + " "
				);
		
		Produto cleanArchitecture = new Produto();
		cleanArchitecture.setId(2L);
		cleanArchitecture.setNome("Clean Architecture");
		cleanArchitecture.setPrecoUnitario(102.90);
		cleanArchitecture.setQuantidadeEstoque(2L);
		cleanArchitecture.setCategoria(livros);
		System.out.println(cleanArchitecture.getId() + " " 
				+ cleanArchitecture.getNome() + " "
				+ cleanArchitecture.getPrecoUnitario() + " "
				+ cleanArchitecture.getQuantidadeEstoque() + " "
				+ cleanArchitecture.getCategoria().getNome() + " "
				);
		
		Produto monitorDell = new Produto();
		monitorDell.setId(3L);
		monitorDell.setNome("Monitor Dell 27");
		monitorDell.setPrecoUnitario(1889.00);
		monitorDell.setQuantidadeEstoque(3L);
		monitorDell.setCategoria(informatica);
		System.out.println(monitorDell.getId() + " " 
				+ monitorDell.getNome() + " "
				+ monitorDell.getPrecoUnitario() + " "
				+ monitorDell.getQuantidadeEstoque() + " "
				+ monitorDell.getCategoria().getNome() + " "
				);
	}
}
