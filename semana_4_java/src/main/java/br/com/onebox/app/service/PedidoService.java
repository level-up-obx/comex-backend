package br.com.onebox.app.service;

import br.com.onebox.app.dtos.ItemPedidoDTO;
import br.com.onebox.app.dtos.PedidoDTO;
import br.com.onebox.app.entity.Cliente;
import br.com.onebox.app.entity.ItemPedido;
import br.com.onebox.app.entity.Pedido;
import br.com.onebox.app.entity.Produto;

import br.com.onebox.app.exceptions.IdNaoEncontradoException;

import br.com.onebox.app.repositories.ClienteRepository;
import br.com.onebox.app.repositories.PedidoRepository;
import br.com.onebox.app.repositories.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Pedido criarPedido(PedidoDTO pedidoDTO) {
        //Cria um Cliente e salva no banco de dados
        Cliente cliente = new Cliente(pedidoDTO.getCliente());
        clienteRepository.save(cliente);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setData(pedidoDTO.getDataPedido());

        List<ItemPedido> itens = new ArrayList<>();

        if (pedidoDTO.getItens() == null || pedidoDTO.getItens().isEmpty()) {
            throw new IllegalArgumentException("O pedido deve ter pelo menos um item");
        }

        for (ItemPedidoDTO itemDTO : pedidoDTO.getItens()) {
            Produto produto = produtoRepository.findById(itemDTO.getProdutoId())
                    .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setProduto(produto);
            itemPedido.setQuantidade(itemDTO.getQuantidade());
            itemPedido.setPrecoUnitario(produto.getPrecoUnitario());

            itens.add(itemPedido);
            pedido.adicionarItem(itemPedido);
        }

        pedidoDTO.setItens(ItemPedidoDTO.converter(itens));
        itens.forEach(pedido::adicionarItem);

        Pedido pedidoFinal = new Pedido();
        BeanUtils.copyProperties(pedido, pedidoFinal);

        pedidoRepository.save(pedidoFinal);

        return pedidoFinal;
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }
}
