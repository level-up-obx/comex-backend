package br.com.comex.testes;

import java.math.BigDecimal;

import br.com.comex.entidades.Categoria;
import br.com.comex.entidades.Produto;
import br.com.comex.util.Utils;


public class TesteProduto {
	public static void main(String[] args) throws Exception {

		Categoria informatica =  new Categoria(1L, "INFORMÁTICA");

		Categoria moveis =  new Categoria(2L, "MÓVEIS");
		moveis.setStatus(Boolean.FALSE);

		Categoria livros =  new Categoria(3L, "LIVROS");

		Produto notebookSamsung = new Produto("Notebook Samsung", new BigDecimal(3523.00), 1L, informatica);
		Utils.mostraResultado(notebookSamsung);

		Produto cleanArchitecture = new Produto("Clean Architecture", new BigDecimal(102.90), 2L, livros);
		Utils.mostraResultado(cleanArchitecture);

		Produto monitorDell = new Produto("Monitor Dell 27", new BigDecimal(1889.00), 3L, informatica);

		Utils.mostraResultado(monitorDell);
	}


}
