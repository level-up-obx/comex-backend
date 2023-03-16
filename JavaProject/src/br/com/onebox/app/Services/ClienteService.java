package br.com.onebox.app.Services;

import br.com.onebox.app.domain.Cliente;


public class ClienteService {

    public void cadastrar(Cliente novoCliente) {

        try {

            if (novoCliente.equals(null)) {

                throw new Exception("Não pode ser nulo");
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Cliente get(String cpf) {
        try {

            if (cpf.length() < 11 || cpf.equals() {

                throw new Exception("Não pode ser nulo")

            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}

