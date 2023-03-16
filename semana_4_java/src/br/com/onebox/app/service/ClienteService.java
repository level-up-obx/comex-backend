package br.com.onebox.app.service;

import br.com.onebox.app.domain.Cliente;
import br.com.onebox.app.exceptions.CPFInvalidoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();

    public void cadastrar(Cliente clienteNovo) throws CPFInvalidoException {
        if (!validarCPF(clienteNovo.getCpf())) {
            throw new CPFInvalidoException("CPF INVALIDO!");
        }
        clientes.add(clienteNovo);
    }
  //duplicado
    private boolean validarCPF(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return false;
        }
        return true;
    }

    public Optional<Cliente> get(String cpf) throws CPFInvalidoException {
        if (cpf == null || cpf.length() < 11) {
            throw new CPFInvalidoException("CPF INVÁLIDO");
        }
        return clientes.stream()
                .filter(c -> cpf.equals(c.getCpf()))
                .findFirst();


    }
}
