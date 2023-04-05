package br.com.onebox.app.service;

import br.com.onebox.app.dtos.ItemPedidoDTO;
import br.com.onebox.app.dtos.PedidoDTO;
import br.com.onebox.app.entity.Cliente;
import br.com.onebox.app.entity.ItemPedido;
import br.com.onebox.app.entity.Pedido;
import br.com.onebox.app.entity.Produto;

import br.com.onebox.app.exceptions.CPFInvalidoException;
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
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;


    @Transactional
    public Pedido criarPedido(PedidoDTO pedidoDTO) {
        // Busca o cliente no banco de dados ou cria um novo
        Cliente cliente = clienteRepository.findById(pedidoDTO.getCliente().getId()).orElse(null);
        if (cliente == null) {
            ClienteService clienteService = new ClienteService();
            clienteService.cadastrar(new Cliente());
        }
        Pedido novoPedido = new Pedido();
        novoPedido.setCliente(cliente);

        novoPedido.setDataPedidos(pedidoDTO.getDataPedido());
        List<ItemPedido> itens = new ArrayList<>();
        if (pedidoDTO.getItens() == null || pedidoDTO.getItens().isEmpty()) {
            throw new IllegalArgumentException("O pedido deve ter pelo menos um item");
        }
        for (ItemPedidoDTO itemDTO : pedidoDTO.getItens()) {
            Produto produto = produtoRepository.findById(itemDTO.getIdProduto())
                    .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setProduto(produto);
            itemPedido.setQuantidade(itemDTO.getQuantidade());
            itemPedido.setPrecoUnitario(produto.getPrecoUnitario());

            itens.add(itemPedido);
            novoPedido.setPreco(pedidoDTO.getPreco());
            novoPedido.adicionarItem(itemPedido);
        }

        itens.forEach(novoPedido::adicionarItem);

        pedidoRepository.save(novoPedido);

        return novoPedido;
    }



    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }
}
