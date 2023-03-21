package br.com.comex.services;

import br.com.comex.entidades.Categoria;
import br.com.comex.entidades.Produto;

public class CategoriaService {
	
	//
	// Crie um método que receba uma nova categoria e faça a devida validação 
	// se ela é ou não válida para posteriormente salvarmos no banco de dados.
	
	public void cadastrar(Categoria novaCategoria){
		
	}
	
	public Categoria getCategoriaById(Long id) {
		if(id.equals(null)) 
			throw new RuntimeException("Para buscar uma Categoria, precisa de um id válido");
				
		return null;

	}
}
