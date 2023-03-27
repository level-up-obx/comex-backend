package com.onebox_comex.entity;
import com.onebox_comex.enums.TipoDescontoPedidoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
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
    private List<ItemPedido> itensPedidos;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal desconto;
    @Column(nullable = false)
    private TipoDescontoPedidoEnum tipoDescontoPedidoEnum;

    public Pedido(Cliente cliente, LocalDate data) {
        this.cliente = cliente;
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getData() {
        return data;
    }

}
