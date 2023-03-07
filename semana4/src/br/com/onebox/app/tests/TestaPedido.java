package br.com.onebox.app.tests;

import br.com.onebox.app.domain.Pedido;
import br.com.onebox.app.domain.Produto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.domain.Cliente;

public class TestaPedido {

	public static void main(String[] args) {
		
		Categoria categoria1 = new Categoria(0, "INFORMATICA", Boolean.TRUE);
        Categoria categoria2 = new Categoria(2, "LIVROS", Boolean.TRUE);
		
		
		Produto produto1 = new Produto (1, "Notebook Samsung", "Informatica", new BigDecimal("3523.00"), 1,categoria1);
		Produto produto2 = new Produto (2, "Clean Architecture", "Livros", new BigDecimal("102.90"), 2, categoria2);
		Produto produto3 = new Produto (3, "Monitor Dell 27","Informatica", new BigDecimal("1889.00"), 3, categoria1);
		
		Cliente cliente1 = new Cliente(1, "Marina", "Lira", "525.800.588-77", "(11)976546543", "Rua das Coxinhas", 
				"201", "Casa", "Jd das Flores", "Sao Paulo", "Sao Paulo");
		Cliente cliente2 = new Cliente(2, "Fernanda", "Melo", "540.300.32-80", "(11)987963251", "Rua dos Sonhos", 
				"800", "ap 300 bloco 4", "Ocian", "Praia Grande", "Sao Paulo");
		Cliente cliente3 = new Cliente(3, "Demi", "Lovato", "008.650.900-11", "(11)978542015", "Rua dos Famosos", 
				"1500", "Mansao", "Brooklyn", "Nova York", "Nova York");
		
		Pedido pedido1 = new Pedido(cliente1, new BigDecimal("3523.00"), 1, LocalDate.now());
		Pedido pedido2 = new Pedido(cliente2, new BigDecimal("102.90"), 1, LocalDate.now());
		Pedido pedido3 = new Pedido(cliente3, new BigDecimal("1889"), 1, LocalDate.now());
		
		System.out.println("Retorno dos pedidos: \n");
		
		System.out.println("-------Pedido 1-------");
		System.out.println(produto1.getNome()+ pedido1.toString());
		
		System.out.println("-------Pedido 2-------");
        System.out.println(produto2.getNome()+ pedido2.toString());
        
        System.out.println("-------Pedido 3-------");
        System.out.println(produto3.getNome()+ pedido3.toString());
		
		
		
		

	}

}
