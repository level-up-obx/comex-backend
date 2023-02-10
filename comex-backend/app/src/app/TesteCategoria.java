package app;

public class TesteCategoria {

//	id 1, nome INFORMÁTICA, status ativa
//	id 2, nome MÓVEIS, status inativa
//	id 3, nome LIVROS, status ativa
	
	public static void main(String[] args) {
		Categoria informatica =  new Categoria();
		informatica.setId(1L);
		informatica.setNome("INFORMÁTICA");
		System.out.println(informatica.getNome() + "( " + informatica.getId() + " - " + informatica.getStatus() + ")");
		
		Categoria moveis =  new Categoria();
		moveis.setId(2L);
		moveis.setNome("MÓVEIS");
		moveis.setStatus("INVATIVA");
		System.out.println(moveis.getNome() + "( " + moveis.getId() + " - " + moveis.getStatus() + ")");
		
		Categoria livros =  new Categoria();
		livros.setId(3L);
		livros.setNome("LIVROS");
		System.out.println(livros.getNome() + "( " + livros.getId() + " - " + livros.getStatus() + ")");
		

	}

}
