package br.com.onebox.app.service;

import br.com.onebox.app.api.pedido.ItemPedidoDto;
import br.com.onebox.app.api.pedido.PedidoDto;
import br.com.onebox.app.api.pedido.PedidoForm;
import br.com.onebox.app.api.pedido.ProdutoDoPedidoForm;
import br.com.onebox.app.domain.*;
import br.com.onebox.app.exception.ProdutoInvalidoException;
import br.com.onebox.app.repository.ClienteRepository;
import br.com.onebox.app.repository.PedidoRepository;
import br.com.onebox.app.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    public void cadastrar(PedidoForm obj) throws ProdutoInvalidoException {
        Cliente cliente = clienteRepository.findById(obj.getClienteId()).orElseThrow();
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setData(LocalDateTime.now());
        for(ProdutoDoPedidoForm produtoDoPedidoForm : obj.getItens()) {
            Produto produto = produtoRepository.findById(obj.getClienteId()).orElseThrow();
            if (produto.getQuantidadeEmEstoque() <= 0) {
                throw new ProdutoInvalidoException("Produto sem estoque");
            }
            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setPedido(pedido);
            itemPedido.setProduto(produto);
            itemPedido.setPrecoUnitario(produto.getPrecoUnitario());
            itemPedido.setQuantidade(produtoDoPedidoForm.getQuantidadeDeItens());

            if (produtoDoPedidoForm.getQuantidadeDeItens() >= 10) {
                itemPedido.setDesconto(produto.getPrecoUnitario().multiply(BigDecimal.valueOf(0.1)));
                itemPedido.setTipoDesconto(TipoDescontoProdutoEnum.QUANTIDADE);
            } else {
                itemPedido.setDesconto(BigDecimal.ZERO);
                itemPedido.setTipoDesconto(TipoDescontoProdutoEnum.NENHUM);
            }
            Integer quantidadePedidosCliente = pedidoRepository.contaPedidosPeloClienteId(cliente.getId());
            if (quantidadePedidosCliente >= 5) {
                pedido.setDesconto(produto.getPrecoUnitario().multiply(BigDecimal.valueOf(0.05)));
                pedido.setTipoDescontoPedidoEnum(TipoDescontoPedidoEnum.FIDELIDADE);
            } else {
                pedido.setDesconto(BigDecimal.ZERO);
                pedido.setTipoDescontoPedidoEnum(TipoDescontoPedidoEnum.NENHUM);
            }
            obj.getItens().add(produtoDoPedidoForm);
            Pedido pedidoFinal = new Pedido();
            BeanUtils.copyProperties(obj,pedidoFinal);
            pedidoRepository.save(pedidoFinal);
        };
    }

    public Optional<Integer> getQuantidadeDePedidos(Optional<List<Pedido>> pedidos) {
        return Optional.of(pedidos.get().size());
    }
}
