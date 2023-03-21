package main.java.br.com.comex.testes;

import main.java.br.com.comex.entidades.Cliente;
import main.java.br.com.comex.util.*;
public class TesteCliente {
	
	public static void main(String[] args) {
		
		Cliente jose = new Cliente("Jose", "Carlos", "305.315.254-10", "11 97854-9845", "Av. Medeiros", "155B", "", "Caiçara", "Praia Grande", "São Paulo");
		Utils.clienteResumo(jose);
		Cliente maria = new Cliente("Maria", "Ruth", "305.315.254-10", "11 97854-9845", "Av. Medeiros", "155B", "", "Caiçara", "Praia Grande", "São Paulo");
		Utils.clienteResumo(maria);
		Cliente luano = new Cliente("Luano", "Monteiro", "300.325.221-10", "13 85471-1245", "Av. Wasinho", "1023", "APTO 123", "Boqueirão", "Praia Grande", "São Paulo");
		Utils.clienteResumo(luano);
	}
	


}
