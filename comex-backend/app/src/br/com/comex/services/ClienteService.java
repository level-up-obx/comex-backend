package br.com.comex.services;

import br.com.comex.entidades.Cliente;

public class ClienteService {
	
	
	public void cadastrar(Cliente novoCliente){
		if(isCpfValid(novoCliente.getCpf())){
			throw new RuntimeException("CPF Invalido");
		}
		
	}
	
	public Cliente getClienteByCpf(String cpf) {
		return null;
		
	}
	
	private Boolean isCpfValid(String cpf) {
		
		return Integer.valueOf(cpf.length()).equals(11);
	}

}
