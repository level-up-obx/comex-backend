package br.com.onebox.app.service;

import br.com.onebox.app.domain.Cliente;
import br.com.onebox.app.exception.ClienteInvalidoException;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    List<Cliente> clientes = new ArrayList<Cliente>();

    public void cadastrar(Cliente novoCliente) throws ClienteInvalidoException {
        try {
            if (novoCliente.equals(null) || (novoCliente.getPrimeiroNome().equals(""))) {
                throw new ClienteInvalidoException("Cliente invalido, valor nulo");
            }
            clientes.add(novoCliente);
            System.out.println("Cliente cadastrado com sucesso!");
        } catch (ClienteInvalidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public Cliente get(String cpf) throws ClienteInvalidoException {
        try {
            if (cpf.equals(null) || cpf.length() > 11) {
                throw new ClienteInvalidoException("Cpf nulo ou inválido");
            }
            return clientes.stream()
                    .filter(c -> c.getCpf() == cpf)
                    .findFirst()
                    .get();
        } catch (ClienteInvalidoException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
