package br.com.comex.testes;

import br.com.comex.entidades.Categoria;
import br.com.comex.exceptions.CampoObrigatorioException;

public class TestaCategoriaValidacaoNome {

	public static void main(String[] args) throws CampoObrigatorioException{
		
		Categoria moveis =  new Categoria(2L, "MÓVEIS");
		moveis.setStatus(Boolean.FALSE);
		System.out.println("moveis " + moveis);
		

		Categoria informatica =  new Categoria(1L, "");
		System.out.println("informatica " + informatica);
		
		Categoria informaticaNull =  new Categoria(1L, null);
		System.out.println("informatica " + informaticaNull);
		
		
	
		Categoria livros =  new Categoria(3L, "LIVROS");
		System.out.println("livros " + livros);
		
		Categoria saude =  new Categoria(3L, "SAUDE");
		System.out.println("saude " + saude);
		
		
		
//		try{
//		
//			
//			Categoria moveis =  new Categoria(2L, "LIVROSs" );
//			moveis.setStatus(Boolean.FALSE);
//			System.out.println("moveis " + moveis);
//			
//			Categoria livros =  new Categoria(3L, "LIVROS");
//			System.out.println("livros " + livros);
//			
//			Categoria informatica =  new Categoria(1L, "");
//			System.out.println("informatica " + informatica);
//			
//			Categoria saude =  new Categoria(3L, "SAUDE");
//			System.out.println("saude " + saude);
//			
//		}catch(RuntimeException e) {
//			System.out.println("Erro no TestaCategoriaValidacaoNome: " + e.getMessage());
//			// throw e;
//		}
		
	}

}
