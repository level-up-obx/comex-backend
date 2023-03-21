package br.com.comex.util;

import br.com.comex.entidades.Cliente;
import br.com.comex.entidades.Estoque;
import br.com.comex.entidades.Produto;

public class Utils {

	public static void printaPraMim(Estoque estoque) {
		System.out.println("");
		System.out.println("Buscando estoque...");
		System.out.println("----------------");
		System.out.println("Capacidade atual: " + estoque.getCapacidade());
		System.out.println("Ocupacao atual: " + estoque.getOcupacao());
		System.out.println("Montante atual: " + estoque.getMontante());
		System.out.println("----------------");

	}

	public static void mostraResultado(Produto produto) {
		System.out.println("");
		System.out.println("Buscando...");
		System.out.println("----------------");
		System.out.println("Produto ID: " + produto.getId() + " -> " + produto.getNome());
		System.out.println("Preço unitário: " + produto.getPrecoUnitario());
		System.out.println("Valor de imposto: R$ " + produto.calculaImposto());
		System.out.println("Qnt Estoque: " + produto.getQuantidadeEstoque());
		System.out.println("Valor total do estoque: R$ " + produto.valorTotalEstoque());
		System.out.println("Categoria: " + produto.getCategoria().getNome());
		System.out.println("----------------");

	}

	public static void clienteResumo(Cliente cliente) {

		System.out.println("");
		System.out.println("Buscando...");
		System.out.println("DADOS DO CLIENTE: " + cliente.getId());
		System.out.println("----------------");
		System.out.println("Nome completo: " + cliente.nomeCompleto());
		System.out.println("Telefone: " + cliente.getTelefone());
		System.out.println("Endereço: " + cliente.enderecoCompleto());
		System.out.println("----------------");

	}

}
