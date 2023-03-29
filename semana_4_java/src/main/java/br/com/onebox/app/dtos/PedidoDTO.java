package br.com.onebox.app.dtos;

import java.time.LocalDate;
import java.util.List;

public class PedidoDTO {
    private final LocalDate dataPedido;
    private Long idCliente;
    private List<ItemPedidoDTO> itens;

    public PedidoDTO(Long idCliente, List<ItemPedidoDTO> itens) {
        this.idCliente = idCliente;
        this.itens = itens;
        this.dataPedido = LocalDate.now();
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public List<ItemPedidoDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoDTO> itens) {
        this.itens = itens;
    }
}
