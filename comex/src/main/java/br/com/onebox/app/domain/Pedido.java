package br.com.onebox.app.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Column(length = 9, nullable = false)
    private LocalDateTime data;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens = new ArrayList<>();

    @Column(length = 3, nullable = false)
    private BigDecimal desconto;

    @Enumerated(EnumType.STRING)
    private TipoDescontoPedidoEnum tipoDescontoPedidoEnum;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    public Pedido(LocalDateTime data, List<ItemPedido> itens, BigDecimal desconto, TipoDescontoPedidoEnum tipoDescontoPedidoEnum, Cliente cliente) {
        this.data = data;
        this.itens = itens;
        this.desconto = desconto;
        this.tipoDescontoPedidoEnum = tipoDescontoPedidoEnum;
        this.cliente = cliente;
    }

    public Pedido(){

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public TipoDescontoPedidoEnum getTipoDescontoPedidoEnum() {
        return tipoDescontoPedidoEnum;
    }

    public void setTipoDescontoPedidoEnum(TipoDescontoPedidoEnum tipoDescontoPedidoEnum) {
        this.tipoDescontoPedidoEnum = tipoDescontoPedidoEnum;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public BigDecimal getValorTotal(){
        BigDecimal valorTotal = BigDecimal.ZERO;
        for(ItemPedido item : this.itens){
            valorTotal = valorTotal.add(item.getTotal());
        }
        return valorTotal;
    }

    @Override
    public String toString() {
        return "Cliente = " + cliente.nomeCompleto() +
                ", Preco = " + getValorTotal() +
                ", Data = " + data;
    }

    public boolean isMaisBaratoQue(Pedido outroPedido){
        return this.getValorTotal().compareTo(outroPedido.getValorTotal()) < 0;
    }

    public boolean isMaisCaroQue(Pedido outroPedido){
        return this.getValorTotal().compareTo(outroPedido.getValorTotal()) > 0;
    }

    public void adicionarItem(ItemPedido item){
        item.setPedido(this);
        this.itens.add(item);
    }
}
