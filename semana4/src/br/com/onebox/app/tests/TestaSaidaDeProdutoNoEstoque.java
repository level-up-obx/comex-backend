package br.com.onebox.app.tests;

import br.com.onebox.app.domain.Estoque;
import br.com.onebox.app.domain.produtoIsento;
import br.com.onebox.app.domain.Categoria;
import java.math.BigDecimal;



public class TestaSaidaDeProdutoNoEstoque extends Estoque {

	public TestaSaidaDeProdutoNoEstoque(int capacidade) {
		super(capacidade);
		
	}

	public static void main(String[] args) 
	{
		Categoria categoria1 = new Categoria(1, "SAUDE", Boolean.TRUE);
		
		produtoIsento produto1 = new produtoIsento(1, "Vacina", "Vacina de gripe", new BigDecimal(250.00), 500, categoria1);
		
		Estoque estoque = new Estoque(1000);
		
		estoque.registraEntrada(produto1);
		
		System.out.println("---- Dados do estoque - Entrada ----");
		System.out.println("Nome produto: " + produto1.getNome());
        System.out.println("Capacidade: " + estoque.getCapacidade());
        System.out.println("Ocupacao: " + estoque.getOcupacao());
        System.out.println("Montante: " + estoque.getMontante());
        
        estoque.registraSaida(produto1);
        System.out.println();
        
        System.out.println("---- Dados do estoque - Saida ----");
		System.out.println("Nome produto: " + produto1.getNome());
        System.out.println("Capacidade: " + estoque.getCapacidade());
        System.out.println("Ocupacao: " + estoque.getOcupacao());
        System.out.println("Montante: " + estoque.getMontante());
        
        
	}

}
