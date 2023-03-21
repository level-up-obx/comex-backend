package main.java.br.com.comex.testes;

import java.math.BigDecimal;

import main.java.br.com.comex.entidades.Categoria;
import main.java.br.com.comex.entidades.Produto;
import main.java.br.com.comex.entidades.ProdutoIsento;
import main.java.br.com.comex.exceptions.CampoObrigatorioException;
import main.java.br.com.comex.util.Utils;

public class TestaProdutoValidacaoPrecoUnitario {

	public static void main(String[] args){

		try {
			Categoria informatica  =  new Categoria(1L, "INFORMÁTICA");;
			Categoria moveis =  new Categoria(2L, "MÓVEIS");
			Categoria livros =  new Categoria(3L, "LIVROS");
			Categoria saude = new Categoria(4L, "SAUDE");

			Produto vacina = new ProdutoIsento("Vacina",new BigDecimal(250.00), 1000L, saude);
			Produto macBookPro = new Produto("Java",new BigDecimal(0.0), 11L, informatica);

			Utils.mostraResultado(macBookPro);
			Utils.mostraResultado(macBookPro);
			Utils.mostraResultado(macBookPro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
