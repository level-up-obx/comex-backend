package br.com.comex.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.comex.entidades.Categoria;
import br.com.comex.entidades.Cliente;
import br.com.comex.entidades.Pedidos;
import br.com.comex.entidades.Produto;
import br.com.comex.util.Utils;

public class TestePedidos {

	public static void main(String[] args) {

		Cliente jose = new Cliente("Jose", "Carlos", "305.315.254-10", "11 97854-9845", "Av. Medeiros", "155B", "", "Caiçara", "Praia Grande", "São Paulo");

		
		try {
			Categoria informatica = new Categoria(1L, "INFORMÁTICA");
			Categoria moveis =  new Categoria(2L, "MÓVEIS");
			Categoria livros =  new Categoria(3L, "LIVROS");
			
			Produto notebookSamsung = new Produto("Notebook Samsung", new BigDecimal(3523.00), 1L, informatica);
			Produto cleanArchitecture = new Produto("Clean Architecture", new BigDecimal(102.90), 2L, livros);
			Produto monitorDell = new Produto("Monitor Dell 27", new BigDecimal(1889.00), 3L, informatica);

			Pedidos pedidoUm = new Pedidos(jose, notebookSamsung.getPrecoUnitario(), 1L,LocalDateTime.now());
			exibePedidos(pedidoUm, notebookSamsung);
			Pedidos pedidoDois = new Pedidos(jose, cleanArchitecture.getPrecoUnitario(), 3L,LocalDateTime.now());
			exibePedidos(pedidoDois, cleanArchitecture);
			Pedidos pedidoTre = new Pedidos(jose, monitorDell.getPrecoUnitario(), 2L,LocalDateTime.now());
			exibePedidos(pedidoDois, monitorDell);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void exibePedidos(Pedidos pedidos, Produto produto) {
		System.out.println(produto.getNome() + ", " + pedidos.getCliente().getPrimeiroNome() + ", " + pedidos.getPreco() + ", " + pedidos.getData().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm")) );
	}

}
