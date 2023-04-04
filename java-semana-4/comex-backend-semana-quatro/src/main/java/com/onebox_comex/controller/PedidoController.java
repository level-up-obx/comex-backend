package com.onebox_comex.controller;

import com.onebox_comex.dtos.NovoPedidoDTO;
import com.onebox_comex.entity.Pedido;
import com.onebox_comex.service.PedidoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public Pedido criarPedido(@RequestBody @Valid NovoPedidoDTO novoPedidoDTO) {
        return pedidoService.criarPedido(novoPedidoDTO);
    }

}

