package br.com.onebox.app.domain;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
    @Column(nullable = false)
    private LocalDate data;
    @Column(nullable = false)
    private ItemPedido itemPedido;
    @Column(nullable = false)
    private TipoDescontoPedidoEnum tipoDescontoPedidoEnum;

    public Pedido(Cliente cliente, BigDecimal preco, int quantidade, LocalDate data) {
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
