package com.onebox_comex.service;

import com.onebox_comex.dtos.ClienteDTO;
import com.onebox_comex.entity.Cliente;
import com.onebox_comex.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    private static final String REGEX_CPF = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$";
    private static final Pattern PATTERN_CPF = Pattern.compile(REGEX_CPF);

    private void validarCpf(String cpf) throws Exception {
        try {
            if (cpf == null || cpf.isBlank()) {
                throw new Exception("CPF não informado");
            }
            Matcher matcher = PATTERN_CPF.matcher(cpf);
            if (!matcher.matches()) {
                throw new Exception("CPF inválido.");
            }
        } catch (Exception clienteCpfException) {
            System.out.println("O erro ocorrido foi: " + clienteCpfException.getMessage());
            throw clienteCpfException;
        }

    }
    public Cliente cadastrarCliente(ClienteDTO clienteDTO) throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setPrimeiroNome(clienteDTO.getPrimeiroNome());
        cliente.setSobrenome(clienteDTO.getSobrenome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setRua(clienteDTO.getRua());
        cliente.setNumero(clienteDTO.getNumero());
        cliente.setComplemento(clienteDTO.getComplemento());
        cliente.setBairro(clienteDTO.getBairro());
        cliente.setCidade(clienteDTO.getCidade());
        cliente.setEstado(clienteDTO.getEstado());

        Optional<Cliente> clienteOptional = clienteRepository.findByCpf(clienteDTO.getCpf());
        try {
            validarCpf(clienteDTO.getCpf());
            if (clienteOptional.isPresent()) {
                throw new Exception("Já existe um CPF com este número");
            }

            return clienteRepository.save(cliente);
        } catch (Exception cadastroClienteException) {
            System.out.println("O erro ocorrido foi: " + cadastroClienteException.getMessage());
            throw cadastroClienteException;
        }
    }


    public ClienteDTO getById(Long id) throws Exception {
        try {
            if (id == null || id < 1) {
                throw new Exception("O id do cliente é inválido");
            }
            Optional<Cliente> clienteOptional = clienteRepository.findById(id);
            if (clienteOptional.isPresent()) {
                Cliente cliente = clienteOptional.get();
                ClienteDTO clienteDTO = new ClienteDTO();
                clienteDTO.setPrimeiroNome(cliente.getPrimeiroNome());
                clienteDTO.setSobrenome(cliente.getSobrenome());
                clienteDTO.setCpf(cliente.getCpf());
                clienteDTO.setTelefone(cliente.getTelefone());
                clienteDTO.setRua(cliente.getRua());
                clienteDTO.setNumero(cliente.getNumero());
                clienteDTO.setComplemento(cliente.getComplemento());
                clienteDTO.setBairro(cliente.getBairro());
                clienteDTO.setCidade(cliente.getCidade());
                clienteDTO.setEstado(cliente.getEstado());

                return clienteDTO;
            } else {
                throw new Exception("Cliente não encontrado");
            }
        } catch (Exception clienteException) {
            System.out.println("Ocorreu o seguinte erro: " + clienteException.getMessage());
            throw clienteException;
        }
    }

    }


