package com.onebox_comex.entity;
import com.onebox_comex.enums.TipoDescontoPedidoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
    @Column(nullable = false)
    private LocalDate data;
    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itensPedidos = new ArrayList<>();
    @Column(precision = 10, scale = 2)
    private BigDecimal desconto;
    @Column
    private TipoDescontoPedidoEnum tipoDescontoPedidoEnum;

    @Column(nullable = false, length = 200)
    private int quantidadeDePedidos;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precoPedido;

    public BigDecimal getValorTotal(){
        BigDecimal valorTotal = BigDecimal.ZERO;
        for(ItemPedido item : this.itensPedidos){
            valorTotal = valorTotal.add(item.getTotal());
        }
        return valorTotal;
    }

    public Pedido(Cliente cliente, List<ItemPedido> itensPedidos, BigDecimal desconto, TipoDescontoPedidoEnum tipoDescontoPedidoEnum) {
        this.cliente = cliente;
        this.data = LocalDate.now();
        this.itensPedidos = itensPedidos;
        this.desconto = desconto;
        this.tipoDescontoPedidoEnum = tipoDescontoPedidoEnum;
    }

    public Pedido(List<ItemPedido> itens, Cliente cliente) {
        adicionaItens(itens);
        this.cliente = cliente;
        this.data = LocalDate.from(LocalDateTime.now());
    }

    @Override
    public String toString() {
        return "Pedido{" +
                ", cliente='" + cliente + '\'' +
                ", data=" + data +
                '}';
    }
    public void adicionarItem(ItemPedido item){
        item.setPedido(this);
        this.itensPedidos.add(item);
    }
    public void adicionaItens(List<ItemPedido> itens) {
        itens.forEach(item -> {
            item.setPedido(this);
            this.itensPedidos.add(item);
        });

    }


}
