package app;

public class TesteCliente {
	
	public static void main(String[] args) {
		
		Cliente jose = new Cliente("Jose", "Carlos", "305.315.254-10", "11 97854-9845", "Av. Medeiros", "155B", "", "Caiçara", "Praia Grande", "São Paulo");
		clienteResumo(jose);
		Cliente maria = new Cliente("Maria", "Ruth", "305.315.254-10", "11 97854-9845", "Av. Medeiros", "155B", "", "Caiçara", "Praia Grande", "São Paulo");
		clienteResumo(maria);
		Cliente luano = new Cliente("Luano", "Monteiro", "300.325.221-10", "13 85471-1245", "Av. Wasinho", "1023", "APTO 123", "Boqueirão", "Praia Grande", "São Paulo");
		clienteResumo(luano);
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
