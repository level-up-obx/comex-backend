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
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoController(PedidoService pedidoService, PedidoRepository pedidoRepository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
        this.pedidoService = pedidoService;
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> criarPedido(@RequestBody @Valid NovoPedidoDTO novoPedidoDTO, UriComponentsBuilder uriBuilder) {
          Pedido pedido = pedidoService.popularPedido(clienteRepository, produtoRepository, novoPedidoDTO);
//        Pedido pedido = pedidoService.criarPedido(novoPedidoDTO);
          pedidoRepository.save(pedido);
        URI uri = uriBuilder.path("/pedidos/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body(new PedidoDTO(pedido));
    }

}

