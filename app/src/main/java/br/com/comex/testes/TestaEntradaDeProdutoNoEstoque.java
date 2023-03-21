package br.com.comex.testes;
import java.math.BigDecimal;
import br.com.comex.util.*;


import br.com.comex.entidades.Categoria;
import br.com.comex.entidades.Estoque;
import br.com.comex.entidades.Produto;
import br.com.comex.entidades.ProdutoIsento;

public class TestaEntradaDeProdutoNoEstoque {

	public static void main(String[] args) throws Exception {


		Categoria informatica =  new Categoria(1L, "INFORMÁTICA");
		Categoria moveis =  new Categoria(2L, "MÓVEIS");
		Categoria livros =  new Categoria(3L, "LIVROS");
		Categoria saude =  new Categoria(3L, "SAUDE");

		Produto vacina = new ProdutoIsento("Vacina",new BigDecimal(250.00), 500L, saude);
		Produto java = new ProdutoIsento("Java",new BigDecimal(112.90), 5L, livros);
		Produto macBookPro = new Produto("Java",new BigDecimal(20000.00), 11L, informatica);


		Estoque estoque = new Estoque();

		Utils.printaPraMim(estoque);
		estoque.registraEntrada(vacina);
		Utils.printaPraMim(estoque);
		estoque.registraEntrada(java);
		Utils.printaPraMim(estoque);
		estoque.registraEntrada(macBookPro);
		Utils.printaPraMim(estoque);

	}




}
