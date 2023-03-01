package br.com.onebox.app.tests;
import br.com.onebox.app.domain.Cliente;

public class TestaCliente {

	public static void main(String[] args) 
	{
		Cliente cliente1 = new Cliente(1, "Marina", "Lira", "525.800.588-77", "(11)976546543", "Rua das Coxinhas", 
				"201", "Casa", "Jd das Flores", "Sao Paulo", "Sao Paulo");
		Cliente cliente2 = new Cliente(2, "Fernanda", "Melo", "540.300.32-80", "(11)987963251", "Rua dos Sonhos", 
				"800", "ap 300 bloco 4", "Ocian", "Praia Grande", "Sao Paulo");
		Cliente cliente3 = new Cliente(3, "Demi", "Lovato", "008.650.900-11", "(11)978542015", "Rua dos Famosos", 
				"1500", "Mansao", "Brooklyn", "Nova York", "Nova York");
		
		
		System.out.println("-------Cliente 1-------");
        System.out.println("CPF: " + cliente1.getCpf());
        System.out.println("Nome completo: " + cliente1.nomeCompleto());
        System.out.println("Telefone: " + cliente1.getTelefone());
        System.out.println("Endereco: " + cliente1.mostraEndereco());
        
        System.out.println("-------Cliente 2-------");
        System.out.println("CPF: " + cliente2.getCpf());
        System.out.println("Nome completo: " + cliente2.nomeCompleto());
        System.out.println("Telefone: " + cliente2.getTelefone());
        System.out.println("Endereco: " + cliente2.mostraEndereco());
        
        System.out.println("-------Cliente 3-------");
        System.out.println("CPF: " + cliente3.getCpf());
        System.out.println("Nome completo: " + cliente3.nomeCompleto());
        System.out.println("Telefone: " + cliente3.getTelefone());
        System.out.println("Endereco: " + cliente3.mostraEndereco());
        
	}

}
