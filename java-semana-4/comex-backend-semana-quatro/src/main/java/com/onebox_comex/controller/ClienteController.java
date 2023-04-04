package com.onebox_comex.controller;

import com.onebox_comex.dtos.ClienteDTO;
import com.onebox_comex.entity.Cliente;
import com.onebox_comex.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> cadastrarCliente(@RequestBody ClienteDTO clienteDTO)  {
        try {
            Cliente cliente = clienteService.cadastrarCliente(clienteDTO);
            ClienteDTO clientePostDTO = new ClienteDTO(cliente.getPrimeiroNome(), cliente.getSobrenome(), cliente.getCpf(), cliente.getTelefone(), cliente.getRua(), cliente.getNumero(), cliente.getComplemento(), cliente.getBairro(), cliente.getCidade(), cliente.getEstado());
            return ResponseEntity.ok(clientePostDTO);
        } catch (Exception postClienteException) {
            postClienteException.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ClienteDTO getById(@PathVariable Long id) throws Exception {
        return clienteService.getById(id);
    }
}
