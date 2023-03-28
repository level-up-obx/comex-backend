package com.onebox_comex.entity;

import com.onebox_comex.enums.TipoDescontoItemPedidoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.math.BigDecimal;

@Entity
@Table(name = "itemPedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precoUnitario;
    @Column(nullable = false)
    private int quantidade;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal desconto;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoDescontoItemPedidoEnum tipoDescontoItemPedido;

    }

