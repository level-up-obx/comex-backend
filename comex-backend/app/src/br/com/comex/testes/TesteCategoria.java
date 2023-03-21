package br.com.comex.testes;

import br.com.comex.entidades.Categoria;

public class TesteCategoria {

	public static void main(String[] args) throws Exception {
		Categoria informatica =  new Categoria(1L, "INFORMÁTICA");
		mostraResultadoCategoria(informatica);
		
		Categoria moveis =  new Categoria(2L, "MÓVEIS");
		moveis.setStatus(Boolean.FALSE);
		mostraResultadoCategoria(moveis);
		
		Categoria livros =  new Categoria(3L, "LIVROS");
		mostraResultadoCategoria(livros);
		
	}
	
	public static void mostraResultadoCategoria(Categoria categoria) {
		System.out.println(categoria.getNome() + "( " + categoria.getId() + " - " + categoria.getStatus() + ")");
	}

}
