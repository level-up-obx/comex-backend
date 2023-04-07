package com.onebox_comex.controller;

import com.onebox_comex.dtos.NovoPedidoDTO;
import com.onebox_comex.dtos.PedidoDTO;
import com.onebox_comex.entity.Pedido;
import com.onebox_comex.repository.ClienteRepository;
import com.onebox_comex.repository.PedidoRepository;
import com.onebox_comex.repository.ProdutoRepository;
import com.onebox_comex.service.PedidoService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody @Valid NovoPedidoDTO novoPedidoDTO) throws Exception {

        Pedido pedido = pedidoService.criarPedido(novoPedidoDTO);
        return ResponseEntity.ok(pedido);
    }

}

