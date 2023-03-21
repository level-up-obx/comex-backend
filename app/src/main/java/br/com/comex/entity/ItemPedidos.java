package br.com.comex.entity;

import br.com.comex.entidades.Pedido;
import br.com.comex.entidades.Produto;
import br.com.comex.enums.TipoDescontoProdutoEnum;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "itemPedido")
public class ItemPedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    private BigDecimal precoUnitario;
    @NotNull
    private Long quantidade;
    @NotNull
    @OneToOne
    private Produtos produto;
    @NotNull
    @OneToOne
    private Pedidos pedido;
    @NotNull
    private BigDecimal desconto;
    @NotNull
    private TipoDescontoProdutoEnum tipoDesconto;


}
