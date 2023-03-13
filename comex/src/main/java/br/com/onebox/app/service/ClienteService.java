package br.com.onebox.app.service;

import br.com.onebox.app.domain.Cliente;
import br.com.onebox.app.exceptions.ClienteInvalidoException;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    List<Cliente> clientes = new ArrayList<Cliente>();

    public void cadastrar(Cliente novoCliente) throws ClienteInvalidoException {
        if(novoCliente.equals(null)){
            throw new ClienteInvalidoException("Cliente invalido, valor nulo");
        }
        clientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public Cliente get(String cpf) throws ClienteInvalidoException {
        if(cpf.equals(null) || cpf.length() > 11){
            throw new ClienteInvalidoException("Cpf nulo ou inválido");
        } return clientes.stream()
                .filter(c -> c.getCpf() == cpf)
                .findAny()
                .get();
    }
}
