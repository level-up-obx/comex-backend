package app;

import java.math.BigDecimal;

public class TestaSaidaDeProdutoNoEstoque {

	public static void main(String[] args) {
		Categoria informatica =  new Categoria(1L, "INFORMÁTICA");
		Categoria moveis =  new Categoria(2L, "MÓVEIS");
		Categoria livros =  new Categoria(3L, "LIVROS");
		Categoria saude =  new Categoria(3L, "SAUDE");
		
		Produto vacina = new ProdutoIsento("Vacina",new BigDecimal(250.00), 500L, saude);
		Produto java = new ProdutoIsento("Java",new BigDecimal(112.90), 5L, livros);
		Produto macBookPro = new Produto("Java",new BigDecimal(20000.00), 11L, informatica);
		
		
		Estoque estoque = new Estoque();
		
		printaPraMim(estoque);
		estoque.registraEntrada(vacina);
		printaPraMim(estoque);
		estoque.registraSaida(vacina);
		printaPraMim(estoque);
	}
	
	public static void printaPraMim(Estoque estoque) {
		System.out.println("");
		System.out.println("Buscando estoque...");
		System.out.println("----------------");
		System.out.println("Capacidade atual: " + estoque.getCapacidade());
		System.out.println("Ocupacao atual: " + estoque.getOcupacao());
		System.out.println("Montante atual: " + estoque.getMontante());
		System.out.println("----------------");

	}

}
