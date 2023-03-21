package br.com.comex.entity;

import br.com.comex.entidades.Cliente;
import br.com.comex.enums.TipoDescontoProdutoEnum;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotNull
    private LocalDateTime data;
    @NotNull
    @ManyToOne
    private Clientes cliente;
    @OneToMany
    private List<ItemPedidos> itens;
    @NotNull
    private BigDecimal desconto;
    @NotNull
    private TipoDescontoProdutoEnum tipoDesconto;

}
