package br.com.onebox.app.controllers;

import br.com.onebox.app.domain.*;
import br.com.onebox.app.dtos.ItemPedidoDTO;
import br.com.onebox.app.dtos.PedidoDTO;
import br.com.onebox.app.exceptions.IdNaoEncontradoException;
import br.com.onebox.app.repositories.ClienteRepository;
import br.com.onebox.app.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

import static br.com.onebox.app.domain.TipoDescontoPedidoEnum.FIDELIDADE;

@RestController
    @RequestMapping("/api/pedidos")
    public class PedidoController {

        @Autowired
        private ClienteRepository clienteRepository;

        @Autowired
        private ProdutoRepository produtoRepository;

        @PostMapping
        public ResponseEntity<?> criarPedido(@RequestBody PedidoDTO pedidoDTO) {
            // Verifica se o ID do cliente é válido
            Cliente cliente = clienteRepository.findById(pedidoDTO.getIdCliente())
                    .orElseThrow(() -> new IdNaoEncontradoException( "ID do cliente inválido"));

            // Verifica se os IDs dos produtos são válidos e se há estoque disponível
            List<ItemPedido> itens = new ArrayList<>();
            for (ItemPedidoDTO itemDTO : pedidoDTO.getItens()) {
                Produto produto = produtoRepository.findById(itemDTO.getIdProduto())
                        .orElseThrow(() -> new IdNaoEncontradoException( "ID do produto inválido"));

                if (produto.getQuantidadeEstoque() < itemDTO.getQuantidade()) {
                    throw new IdNaoEncontradoException("Produto sem estoque suficiente");
                }

                itens.add(new ItemPedido(produto, itemDTO.getQuantidade()));
            }

            // Aplica os descontos
            BigDecimal valorTotal = calcularValorTotal(itens);
            if (itens.stream().anyMatch(item -> item.getQuantidade() > 10)) {
                valorTotal = valorTotal.multiply(new BigDecimal("0.9"));
            }
            if (cliente.getTipoDescontoPedido() == TipoDescontoPedidoEnum.FIDELIDADE && cliente.getPedidos().size() >= 5) {
                valorTotal = valorTotal.multiply(TipoDescontoPedidoEnum.FIDELIDADE.getDesconto());
            }

            // Cria o pedido e atualiza o estoque dos produtos
            Pedido pedido = new Pedido(cliente, itens, new Date(), valorTotal);
            for (ItemPedido item : itens) {
                Produto produto = item.getProduto();
                produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - item.getQuantidade());
                produtoRepository.save(produto);
            }
            cliente.addPedido(pedido);
            clienteRepository.save(cliente);

            return ResponseEntity.ok().build();
        }

        private BigDecimal calcularValorTotal(List<ItemPedido> itens) {
            return itens.stream()
                    .map(item -> item.getProduto().getPrecoUnitario().multiply(new BigDecimal(item.getQuantidade())))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
    }

