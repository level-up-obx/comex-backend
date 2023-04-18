package br.com.onebox.app.service;

import br.com.onebox.app.api.pedido.PedidoDto;
import br.com.onebox.app.api.pedido.PedidoForm;
import br.com.onebox.app.domain.Cliente;
import br.com.onebox.app.domain.ItemPedido;
import br.com.onebox.app.domain.Pedido;
import br.com.onebox.app.domain.Produto;
import br.com.onebox.app.exception.ProdutoInvalidoException;
import br.com.onebox.app.repository.ClienteRepository;
import br.com.onebox.app.repository.ItemPedidoRepository;
import br.com.onebox.app.repository.PedidoRepository;
import br.com.onebox.app.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<PedidoDto> getAll() {

        List<Pedido> pedidos = new ArrayList<>();
        pedidoRepository.findAll().forEach(pedidos::add);

        return PedidoDto.converter(pedidos);
    }

    public PedidoDto get(Long id) {
        Optional<Pedido> obj = pedidoRepository.findById(id);
        Pedido pedido = obj.orElse(new Pedido());

        return new PedidoDto(pedido);
    }

    public void toEntityAndSave(PedidoForm pedidoForm, ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {

        Cliente cliente = clienteRepository.findById(pedidoForm.getClienteId()).get();
        List<ItemPedido> itensPedido = new ArrayList<>();

        pedidoForm.getItens().forEach(listaProdutos -> {
            Produto produto = produtoRepository.findById(listaProdutos.getId()).get();
            if (listaProdutos.getQuantidadeDeItens() > 10) {
                produto.setPrecoUnitario(produto.getPrecoUnitario().multiply(new BigDecimal(0.9)));
                itensPedido.add(new ItemPedido(produto, listaProdutos.getQuantidadeDeItens()));
            }
            itensPedido.add(new ItemPedido(produto, listaProdutos.getQuantidadeDeItens()));
        });
        Pedido pedido = new Pedido(itensPedido, cliente);
        if (cliente.getPedidos().size() > 5) {
            pedido.setDesconto(new BigDecimal(0.95));
            itemPedidoRepository.saveAll(itensPedido);
            pedidoRepository.save(pedido);
        }
        itemPedidoRepository.saveAll(itensPedido);
        pedidoRepository.save(pedido);

    }
}