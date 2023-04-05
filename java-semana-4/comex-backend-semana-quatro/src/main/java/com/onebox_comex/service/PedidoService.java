package com.onebox_comex.service;

import com.onebox_comex.dtos.ClienteDTO;
import com.onebox_comex.dtos.ItemPedidoDTO;
import com.onebox_comex.dtos.NovoPedidoDTO;
import com.onebox_comex.dtos.PedidoDTO;
import com.onebox_comex.entity.Cliente;
import com.onebox_comex.entity.ItemPedido;
import com.onebox_comex.entity.Pedido;
import com.onebox_comex.entity.Produto;
import com.onebox_comex.enums.TipoDescontoItemPedidoEnum;
import com.onebox_comex.enums.TipoDescontoPedidoEnum;
import com.onebox_comex.repository.ClienteRepository;
import com.onebox_comex.repository.PedidoRepository;
import com.onebox_comex.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    public Pedido criarPedido(NovoPedidoDTO novoPedidoDTO) {
        Cliente cliente = clienteRepository.findById(novoPedidoDTO.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Pedido novoPedido = new Pedido();
        novoPedido.setCliente(cliente);
        novoPedido.setData(LocalDate.now());

        for (ItemPedidoDTO novoItemPedidoDTO : novoPedidoDTO.getItensPedidos()) {
           Optional<Produto> optionalProduto = produtoRepository.findById(novoItemPedidoDTO.getProdutoId());

            Produto produto = optionalProduto.orElseThrow(() -> new RuntimeException("Produto não encontrado"));


            if (produto.getQuantidadeEmEstoque() < novoItemPedidoDTO.getQuantidade()) {
                throw new RuntimeException("Estoque insuficiente para o produto " + produto.getNome());
            }


            if (produto.getQuantidadeEmEstoque() < novoItemPedidoDTO.getQuantidade()) {
                throw new RuntimeException("Estoque insuficiente para o produto " + produto.getNome());
            }

            ItemPedido novoItemPedido = new ItemPedido();
            novoItemPedido.setProduto(produto);
            novoItemPedido.setPedido(novoPedido);
            novoItemPedido.setPrecoUnitario(produto.getPrecoUnitario());
            novoItemPedido.setQuantidade(novoItemPedidoDTO.getQuantidade());

            if (novoItemPedidoDTO.getQuantidade() >= 10) {
                novoItemPedido.setDesconto(produto.getPrecoUnitario().multiply(BigDecimal.valueOf(0.1)));
                novoItemPedido.setTipoDescontoItemPedido(TipoDescontoItemPedidoEnum.QUANTIDADE);
            } else {
                novoItemPedido.setDesconto(BigDecimal.ZERO);
                novoItemPedido.setTipoDescontoItemPedido(TipoDescontoItemPedidoEnum.NENHUM);
            }

            novoPedido.getItensPedidos().add(novoItemPedido);
        }

        long quantidadePedidosCliente = pedidoRepository.countByClienteId(cliente.getId());
        if (quantidadePedidosCliente >= 5) {
            BigDecimal valorDescontoFidelidade = novoPedido.getItensPedidos().stream()
                    .map(ItemPedido::getPrecoUnitario)
                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                    .multiply(BigDecimal.valueOf(0.05));
            novoPedido.setDesconto(valorDescontoFidelidade);
            novoPedido.setTipoDescontoPedidoEnum(TipoDescontoPedidoEnum.FIDELIDADE);
        } else {
            novoPedido.setDesconto(BigDecimal.ZERO);
            novoPedido.setTipoDescontoPedidoEnum(TipoDescontoPedidoEnum.NENHUM);
        }

        Pedido pedidoSalvo = pedidoRepository.save(novoPedido);

        for (ItemPedido itemPedido : pedidoSalvo.getItensPedidos()) {
            Produto produto = itemPedido.getProduto();
            int quantidade = itemPedido.getQuantidade();
            produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - quantidade);
            produtoRepository.save(produto);
        }

        return pedidoSalvo;
    }

    public Pedido popularPedido(ClienteRepository clienteRepository, ProdutoRepository produtoRepository, NovoPedidoDTO novoPedidoDTO){

        Cliente cliente = clienteRepository.findById(novoPedidoDTO.getClienteId()).get();
        List<ItemPedido> itensPedidos = new ArrayList<>();

        novoPedidoDTO.getItensPedidos().forEach(listaProdutos -> {
            Produto produto = produtoRepository.findById(listaProdutos.getProdutoId()).get();
            itensPedidos.add(new ItemPedido(produto, listaProdutos.getQuantidade()));
        });

        return new Pedido(itensPedidos, cliente);
    }

//    public Pedido criarPedido(NovoPedidoDTO novoPedidoDTO) {
//        Cliente cliente = clienteRepository.findById(novoPedidoDTO.getClienteId())
//                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
//
//        Pedido pedido = new Pedido();
//        pedido.setCliente(cliente);
//        pedido.setData(LocalDate.now());
//
//        for (ItemPedidoDTO novoItemPedidoDTO : novoPedidoDTO.getItensPedidos()) {
//            Optional<Produto> optionalProduto = produtoRepository.findById(novoItemPedidoDTO.getProdutoId());
//
//            Produto produto = optionalProduto.orElseThrow(() -> new RuntimeException("Produto não encontrado"));
//
//            if (produto.getQuantidadeEmEstoque() < novoItemPedidoDTO.getQuantidade()) {
//                throw new RuntimeException("Estoque insuficiente para o produto " + produto.getNome());
//            }
//
//            ItemPedidoDTO novoItemPedido = new ItemPedidoDTO();
//            novoItemPedido.setClienteId(cliente.getId());
//            novoItemPedido.setProdutoId(produto.getId());
//            novoItemPedido.setQuantidade(novoItemPedidoDTO.getQuantidade());
//            novoItemPedido.setPrecoUnitario(produto.getPrecoUnitario());
//
//            if (novoItemPedidoDTO.getQuantidade() >= 10) {
//                novoItemPedido.setDesconto(produto.getPrecoUnitario().multiply(BigDecimal.valueOf(0.1)));
//                novoItemPedido.setTipoDescontoItemPedido(TipoDescontoItemPedidoEnum.QUANTIDADE);
//            } else {
//                novoItemPedido.setDesconto(BigDecimal.ZERO);
//                novoItemPedido.setTipoDescontoItemPedido(TipoDescontoItemPedidoEnum.NENHUM);
//            }
//
//            ItemPedido itemPedido = new ItemPedido();
//            BeanUtils.copyProperties(itemPedido, novoItemPedido);
//            pedido.getItensPedidos().add(novoItemPedido);
//        }
//
//        long quantidadePedidosCliente = pedidoRepository.countByClienteId(cliente.getId());
//        if (quantidadePedidosCliente >= 5) {
//            BigDecimal valorDescontoFidelidade = pedido.getItensPedidos().stream()
//                    .map(ItemPedido::getPrecoUnitario)
//                    .reduce(BigDecimal.ZERO, BigDecimal::add)
//                    .multiply(BigDecimal.valueOf(0.05));
//            pedido.setDesconto(valorDescontoFidelidade);
//            pedido.setTipoDescontoPedidoEnum(TipoDescontoPedidoEnum.FIDELIDADE);
//        } else {
//            pedido.setDesconto(BigDecimal.ZERO);
//            pedido.setTipoDescontoPedidoEnum(TipoDescontoPedidoEnum.NENHUM);
//        }
//
//        Pedido pedidoSalvo = pedidoRepository.save(pedido);
//
//        for (ItemPedido itemPedido : pedidoSalvo.getItensPedidos()) {
//            Produto produto = itemPedido.getProduto();
//            int quantidade = itemPedido.getQuantidade();
//            produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - quantidade);
//            produtoRepository.save(produto);
//        }
//
//        return pedidoSalvo;
//    }

}




