package br.com.comex.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

import br.com.comex.entidades.Categoria;
import br.com.comex.entidades.Cliente;
import br.com.comex.entidades.Pedido;
import br.com.comex.entidades.Produto;

public class TestaPedidoOrdenado {

	public static void main(String[] args) {

		Cliente jose = new Cliente("Jose", "Carlos", "305.315.254-10", "11 97854-9845", "Av. Medeiros", "155B", "", "Caiçara", "Praia Grande", "São Paulo");

		
		try {
			Categoria informatica = new Categoria(1L, "INFORMÁTICA");
			Categoria moveis =  new Categoria(2L, "MÓVEIS");
			Categoria livros =  new Categoria(3L, "LIVROS");
			
			Produto notebookSamsung = new Produto("Notebook Samsung", new BigDecimal(3523.00), 1L, informatica);
			Produto cleanArchitecture = new Produto("Clean Architecture", new BigDecimal(102.90), 2L, livros);
			Produto monitorDell = new Produto("Monitor Dell 27", new BigDecimal(1889.00), 3L, informatica);

			Pedido pedidoA = new Pedido(jose, notebookSamsung.getPrecoUnitario(), 3L,LocalDateTime.now());
			Pedido pedidoB = new Pedido(jose, cleanArchitecture.getPrecoUnitario(), 6L,LocalDateTime.now());
			Pedido pedidoC = new Pedido(jose, monitorDell.getPrecoUnitario(), 8L,LocalDateTime.now());
			Pedido pedidoD = new Pedido(jose, notebookSamsung.getPrecoUnitario(), 3L,LocalDateTime.now());
			Pedido pedidoE = new Pedido(jose, cleanArchitecture.getPrecoUnitario(), 4L,LocalDateTime.now());
			
			ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
			pedidos.add(pedidoA);
			pedidos.add(pedidoB);
			pedidos.add(pedidoC);
			pedidos.add(pedidoD);
			pedidos.add(pedidoE);
			
			pedidos.stream()
			.sorted(Comparator.comparing(Pedido::getValorTotal))
				.forEach(System.out::println);
			System.out.println("--");
			pedidos.stream()
				.sorted(Comparator.comparing(Pedido::getValorTotal).reversed())
				.forEach(System.out::println);
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void exibePedidos(Pedido pedidos, Produto produto) {
		System.out.println(produto.getNome() + ", " + pedidos.getCliente().getPrimeiroNome() + ", " + pedidos.getPreco() + ", " + pedidos.getData().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm")) );
	}

}
