package br.com.onebox.app.api.pedido;

import br.com.onebox.app.domain.*;
import br.com.onebox.app.repository.ClienteRepository;
import br.com.onebox.app.repository.ProdutoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PedidoForm {
    private Long clienteId;
    private TipoDescontoPedidoEnum tipoDescontoPedidoEnum;
    private List<ProdutoDoPedidoForm> itens;

    public Pedido toEntity(ClienteRepository clienteRepository, ProdutoRepository produtoRepository){

        Cliente cliente = clienteRepository.findById(clienteId).get();
        List<ItemPedido> itensPedido = new ArrayList<>();

        itens.forEach(listaProdutos -> {
            Produto produto = produtoRepository.findById(listaProdutos.getId()).get();
            itensPedido.add(new ItemPedido(produto, listaProdutos.getQuantidadeDeItens()));
        });
        return new Pedido(itensPedido, cliente);
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<ProdutoDoPedidoForm> getItens() {
        return itens;
    }

    public void setItens(List<ProdutoDoPedidoForm> itens) {
        this.itens = itens;
    }

    public TipoDescontoPedidoEnum getTipoDescontoPedidoEnum() {
        return tipoDescontoPedidoEnum;
    }

    public void setTipoDescontoPedidoEnum(TipoDescontoPedidoEnum tipoDescontoPedidoEnum) {
        this.tipoDescontoPedidoEnum = tipoDescontoPedidoEnum;
    }

}
