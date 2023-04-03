package com.onebox_comex.service;

//import com.onebox_comex.dtos.ItemPedidoDTO;
//import com.onebox_comex.dtos.NovoPedidoDTO;
//import com.onebox_comex.entity.Cliente;
//import com.onebox_comex.entity.ItemPedido;
//import com.onebox_comex.entity.Pedido;
//import com.onebox_comex.entity.Produto;
//import com.onebox_comex.enums.TipoDescontoItemPedidoEnum;
//import com.onebox_comex.enums.TipoDescontoPedidoEnum;
//import com.onebox_comex.repository.ClienteRepository;
//import com.onebox_comex.repository.PedidoRepository;
//import com.onebox_comex.repository.ProdutoRepository;
//import org.springframework.stereotype.Service;
//import java.math.BigDecimal;
//import java.time.LocalDate;
//
//@Service
//public class PedidoService {
//
//    private final PedidoRepository pedidoRepository;
//    private final ClienteRepository clienteRepository;
//    private final ProdutoRepository produtoRepository;
//
//    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
//        this.pedidoRepository = pedidoRepository;
//        this.clienteRepository = clienteRepository;
//        this.produtoRepository = produtoRepository;
//    }
//
//    public Pedido criarPedido(NovoPedidoDTO novoPedidoDTO) {
//        Cliente cliente = clienteRepository.findById(novoPedidoDTO.getClienteId())
//                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
//
//        Pedido novoPedido = new Pedido();
//        novoPedido.setCliente(cliente);
//        novoPedido.setData(LocalDate.now());
//
//        for (ItemPedidoDTO novoItemPedidoDTO : novoPedidoDTO.getItensPedidos()) {
//            Produto produto = produtoRepository.findById(novoItemPedidoDTO.getProdutoId())
//                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
//
//            if (produto.getQuantidadeEmEstoque() < novoItemPedidoDTO.getQuantidade()) {
//                throw new RuntimeException("Estoque insuficiente para o produto " + produto.getNome());
//            }
//
//            ItemPedido novoItemPedido = new ItemPedido();
//            novoItemPedido.setProduto(produto);
//            novoItemPedido.setPedido(novoPedido);
//            novoItemPedido.setPrecoUnitario(produto.getPrecoUnitario());
//            novoItemPedido.setQuantidade(novoItemPedidoDTO.getQuantidade());
//
//            if (novoItemPedidoDTO.getQuantidade() >= 10) {
//                novoItemPedido.setDesconto(produto.getPrecoUnitario().multiply(BigDecimal.valueOf(0.1)));
//                novoItemPedido.setTipoDescontoItemPedido(TipoDescontoItemPedidoEnum.QUANTIDADE);
//            } else {
//                novoItemPedido.setDesconto(BigDecimal.ZERO);
//                novoItemPedido.setTipoDescontoItemPedido(TipoDescontoItemPedidoEnum.NENHUM);
//            }
//
//            novoPedido.getItensPedidos().add(novoItemPedido);
//        }
//
//        long quantidadePedidosCliente = pedidoRepository.countByClienteId(cliente.getId());
//        if (quantidadePedidosCliente >= 5) {
//            BigDecimal valorDescontoFidelidade = novoPedido.getItensPedidos().stream()
//                    .map(ItemPedido::getPrecoUnitario)
//                    .reduce(BigDecimal.ZERO, BigDecimal::add)
//                    .multiply(BigDecimal.valueOf(0.05));
//            novoPedido.setDesconto(valorDescontoFidelidade);
//            novoPedido.setTipoDescontoPedidoEnum(TipoDescontoPedidoEnum.FIDELIDADE);
//        } else {
//            novoPedido.setDesconto(BigDecimal.ZERO);
//            novoPedido.setTipoDescontoPedidoEnum(TipoDescontoPedidoEnum.NENHUM);
//        }
//
//        return pedidoRepository.save(novoPedido);
//    }
//
//}
//
//
//
//
