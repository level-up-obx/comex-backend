package br.com.onebox.app.tests;

import java.util.Comparator;
import java.util.List;

import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.domain.Cliente;
import br.com.onebox.app.domain.Pedido;
import br.com.onebox.app.domain.Produto;

import java.util.ArrayList;
import java.util.Collections;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TestaPedidoOrdenado {

	public static void main(String[] args) {
		
		Categoria categoria1 = new Categoria(0, "INFORMATICA", Boolean.TRUE);
        Categoria categoria2 = new Categoria(1, "LIVROS", Boolean.TRUE);
		
		
		Produto produto1 = new Produto (1, "Notebook Samsung", "Informatica", new BigDecimal("3523.00"), 1,categoria1);
		Produto produto2 = new Produto (2, "Clean Architecture", "Livros", new BigDecimal("102.90"), 2, categoria2);
		Produto produto3 = new Produto (3, "Monitor Dell 27","Informatica", new BigDecimal("1889.00"), 3, categoria1);
		Produto produto4 = new Produto (4, "Romeu e Julieta","Livros", new BigDecimal("50.00"), 2, categoria2);
		Produto produto5 = new Produto (5, "Daqui a 5 anos","Livros", new BigDecimal("65.00"), 1, categoria2);
		
		
		
		Cliente cliente1 = new Cliente(1, "Marina", "Lira", "525.800.588-77", "(11)976546543", "Rua das Coxinhas", 
				"201", "Casa", "Jd das Flores", "Sao Paulo", "Sao Paulo");
		Cliente cliente2 = new Cliente(2, "Fernanda", "Melo", "540.300.32-80", "(11)987963251", "Rua dos Sonhos", 
				"800", "ap 300 bloco 4", "Ocian", "Praia Grande", "Sao Paulo");
		Cliente cliente3 = new Cliente(3, "Demi", "Lovato", "008.650.900-11", "(11)978542015", "Rua dos Famosos", 
				"1500", "Mansao", "Brooklyn", "Nova York", "Nova York");
		
		ArrayList<Pedido> pedidos = new ArrayList<>();
		pedidos.add(new Pedido(cliente1, new BigDecimal("3523.00"), 1, LocalDate.of(2022, 3, 12)));
		pedidos.add(new Pedido(cliente2, new BigDecimal("102.90"), 4, LocalDate.of(2021, 5, 12)));
		pedidos.add(new Pedido(cliente2, new BigDecimal("1889.00"), 3, LocalDate.of(2022, 7, 12)));
		pedidos.add(new Pedido(cliente3, new BigDecimal("50.00"), 7, LocalDate.of(2021, 5, 12)));
		pedidos.add(new Pedido(cliente3, new BigDecimal("65.00"), 30, LocalDate.of(2020, 5, 12)));

		System.out.println("--Ordem crescente--");
        pedidos.sort(Comparator.comparing(Pedido -> Pedido.getValorTotal()));
        pedidos.forEach(Pedido -> System.out.println(Pedido));
        
        System.out.println("--Ordem decrescente");
        pedidos.sort(Comparator.comparing(Pedido::getValorTotal).reversed());
        pedidos.forEach(Pedido -> System.out.println(Pedido));
        
        System.out.println("Maior valor: " + "\t"+ pedidos.get(0));
        System.out.println("Menor valor: " + "\t" + pedidos.get(pedidos.size()-1));
	
	}
		
    }

	   
	

	
		
	

