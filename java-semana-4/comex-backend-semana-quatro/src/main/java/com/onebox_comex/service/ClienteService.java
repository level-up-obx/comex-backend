package com.onebox_comex.service;

import com.onebox_comex.dtos.ClienteDTO;
import com.onebox_comex.dtos.EnderecoDTO;
import com.onebox_comex.entity.Cliente;
import com.onebox_comex.entity.Produto;
import com.onebox_comex.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class ClienteService {

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
        public Cliente cadastrarCliente(ClienteDTO clienteDTO) throws Exception  {
            Optional<Cliente> clienteOptional = clienteRepository.findByCpf(clienteDTO.getCpf());
        try{
            validarCpf(clienteDTO.getCpf());
            if(clienteOptional.isPresent()) {
                throw new Exception("Já existe um CPF com este número");
            }
            Cliente cliente = new Cliente(clienteDTO.getCpf());
            return clienteRepository.save(cliente);
        } catch (Exception cadastroClienteException){
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

                EnderecoDTO enderecoDTO = new EnderecoDTO();
                enderecoDTO.setRua(cliente.getEndereco().getRua());
                enderecoDTO.setNumero(cliente.getEndereco().getNumero());
                enderecoDTO.setComplemento(cliente.getEndereco().getComplemento());
                enderecoDTO.setBairro(cliente.getEndereco().getBairro());
                enderecoDTO.setCidade(cliente.getEndereco().getCidade());
                enderecoDTO.setEstado(cliente.getEndereco().getEstado());

                clienteDTO.setEndereco(enderecoDTO);
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


