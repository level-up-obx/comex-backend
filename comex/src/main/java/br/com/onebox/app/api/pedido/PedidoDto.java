package br.com.onebox.app.api.pedido;

import br.com.onebox.app.api.cliente.ClienteDto;
import br.com.onebox.app.api.pedido.ItemPedidoDto;
import br.com.onebox.app.domain.Pedido;
import br.com.onebox.app.domain.TipoDescontoPedidoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PedidoDto {

    @NotNull @NotBlank
    private Long id;
    private ClienteDto cliente;
    @NotNull @NotBlank
    private BigDecimal desconto;
    @NotNull @NotBlank
    private TipoDescontoPedidoEnum tipoDescontoPedido;
    @NotNull @NotBlank
    private BigDecimal totalPedido;
    private List<ItemPedidoDto> itens = new ArrayList<>();

    public PedidoDto(Pedido pedido){
        this.id = pedido.getId();
        this.cliente = new ClienteDto(pedido.getCliente());
        this.desconto = pedido.getDesconto();
        this.tipoDescontoPedido = pedido.getTipoDescontoPedidoEnum();
        this.totalPedido = pedido.getValorTotal();
        this.itens = new ItemPedidoDto().converter(pedido.getItens());
    }
    public static List<PedidoDto> converter(List<Pedido> objs) {
        List<PedidoDto> retorno = new ArrayList<>();
        objs.forEach(obj -> retorno.add(new PedidoDto(obj)));
        return retorno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public TipoDescontoPedidoEnum getTipoDescontoPedido() {
        return tipoDescontoPedido;
    }

    public void setTipoDescontoPedido(TipoDescontoPedidoEnum tipoDescontoPedido) {
        this.tipoDescontoPedido = tipoDescontoPedido;
    }

    public BigDecimal getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(BigDecimal totalPedido) {
        this.totalPedido = totalPedido;
    }

    public List<ItemPedidoDto> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoDto> itens) {
        this.itens = itens;
    }
}
