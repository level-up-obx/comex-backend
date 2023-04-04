package com.onebox_comex.controller;

import com.onebox_comex.dtos.ClienteDTO;
import com.onebox_comex.entity.Cliente;
import com.onebox_comex.service.ClienteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public Cliente cadastrarCliente(@RequestBody ClienteDTO clienteDTO) throws Exception {
        return clienteService.cadastrarCliente(clienteDTO);
    }

    @GetMapping("/{id}")
    public ClienteDTO getById(@PathVariable Long id) throws Exception {
        return clienteService.getById(id);
    }
}
