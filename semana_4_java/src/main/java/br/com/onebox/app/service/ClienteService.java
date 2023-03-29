package br.com.onebox.app.service;

import br.com.onebox.app.entity.Cliente;
import br.com.onebox.app.exceptions.CPFInvalidoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();

    public void cadastrar(Cliente clienteNovo) throws CPFInvalidoException {
        if (!validarCPF(clienteNovo.getCpf())) {
            throw new CPFInvalidoException("CPF INVALIDO!");
        }
        clientes.add(clienteNovo);
    }

    private boolean validarCPF(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            return false;
        }
        return true;
    }

    public Optional<Cliente> get(String cpf) throws CPFInvalidoException {
        if (!validarCPF(cpf)) {
            throw new CPFInvalidoException("CPF INVÁLIDO");
        }
        return clientes.stream()
                .filter(c -> cpf.equals(c.getCpf()))
                .findFirst();


    }
}
