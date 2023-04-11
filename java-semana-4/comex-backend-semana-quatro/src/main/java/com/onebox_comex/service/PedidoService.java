package com.onebox_comex.service;

import com.onebox_comex.dtos.ItemPedidoDTO;
import com.onebox_comex.dtos.NovoPedidoDTO;
import com.onebox_comex.entity.Cliente;
import com.onebox_comex.entity.ItemPedido;
import com.onebox_comex.entity.Pedido;
import com.onebox_comex.entity.Produto;
import com.onebox_comex.repository.ClienteRepository;
import com.onebox_comex.repository.ItemPedidoRepository;
import com.onebox_comex.repository.PedidoRepository;
import com.onebox_comex.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;
    private final ItemPedidoRepository itemPedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository, ItemPedidoRepository itemPedidoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
        this.itemPedidoRepository = itemPedidoRepository;
    }

    @Transactional
    public Pedido criarPedido(NovoPedidoDTO novoPedidoDTO) throws Exception {
        Cliente cliente = clienteRepository.findById(novoPedidoDTO.getCliente().getId()).orElse(null);
        if (cliente == null) {
            cliente = new Cliente();
            cliente.setPrimeiroNome(novoPedidoDTO.getCliente().getPrimeiroNome());
            cliente.setSobrenome(novoPedidoDTO.getCliente().getSobrenome());
            cliente.setCpf(novoPedidoDTO.getCliente().getCpf());
            cliente.setTelefone(novoPedidoDTO.getCliente().getTelefone());
            cliente.setRua(novoPedidoDTO.getCliente().getRua());
            cliente.setNumero(novoPedidoDTO.getCliente().getNumero());
            cliente.setComplemento(novoPedidoDTO.getCliente().getComplemento());
            cliente.setBairro(novoPedidoDTO.getCliente().getBairro());
            cliente.setCidade(novoPedidoDTO.getCliente().getCidade());
            cliente.setEstado(novoPedidoDTO.getCliente().getEstado());
            clienteRepository.save(cliente);
        }

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setData(novoPedidoDTO.getDataDoPedido());
        pedido.setDesconto(novoPedidoDTO.getDesconto());
        pedido.setQuantidadeDePedidos(novoPedidoDTO.getQuantidade());
        pedido.setTipoDescontoPedidoEnum(novoPedidoDTO.getTipoDescontoPedido());

        List<ItemPedido> itensPedidos = new ArrayList<>();

        for (ItemPedidoDTO itemPedidoDTO : novoPedidoDTO.getItens()) {
            Produto produto = produtoRepository.findById(itemPedidoDTO.getProdutoId())
                    .orElseThrow(() -> new Exception("Produto inexistente"));

            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setProduto(produto);
            itemPedido.setQuantidade(itemPedidoDTO.getQuantidade());
            itemPedido.setPrecoUnitario(produto.getPrecoUnitario());
            itemPedido.setDesconto(itemPedidoDTO.getDesconto());
            itemPedido.setTipoDescontoItemPedido(itemPedidoDTO.getTipoDescontoItemPedido());
            itemPedido.setPedido(itemPedidoDTO.getPedido());
            produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - itemPedidoDTO.getQuantidade());
            produtoRepository.save(produto);

            itensPedidos.add(itemPedido);
            pedido.setPrecoPedido(novoPedidoDTO.getPreco());
            pedido.adicionarItem(itemPedido);

           itemPedidoRepository.save(itemPedido);
        }

        pedidoRepository.save(pedido);

        return pedido;
    }


    public Pedido getById(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

//    public Pedido popularPedido(ClienteRepository clienteRepository, ProdutoRepository produtoRepository, NovoPedidoDTO novoPedidoDTO){
//
//        Cliente cliente = clienteRepository.findById(novoPedidoDTO.getClienteId()).get();
//        List<ItemPedido> itensPedidos = new ArrayList<>();
//
//        novoPedidoDTO.getItensPedidos().forEach(listaProdutos -> {
//            Produto produto = produtoRepository.findById(listaProdutos.getProdutoId()).get();
//            itensPedidos.add(new ItemPedido(produto, listaProdutos.getQuantidade()));
//        });
//
//        return new Pedido(itensPedidos, cliente);
//    }

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




