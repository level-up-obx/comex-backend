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
}
