package br.com.onebox.app.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_pedidos", nullable = false)
    private LocalDate data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientes_id", nullable = false)
    private Cliente cliente;


    @Column(name = "desconto_pedidos", nullable = false, precision = 10, scale = 2)
    private BigDecimal desconto;


    @Column(name = "preco_pedidos", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(name = "quantidade_pedidos", nullable = false, length = 100)
    private int quantidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoDesconto_pedidos", nullable = false, length = 20)
    private TipoDescontoPedido tipoDescontoPedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    private List<ItemPedido> itens = new ArrayList<>();


    public Pedido(Cliente cliente, BigDecimal preco, int quantidade, LocalDate data) {
        this.cliente = cliente;
        this.preco = preco;
        this.quantidade = quantidade;
        this.data = data;
    }

    public void adicionarItem(ItemPedido item) {
        item.setPedido(this);
        this.itens.add(item);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }


    public boolean isMaisBaratoQue(Pedido outroPedido) {
        return preco.compareTo(outroPedido.getPreco()) < 0;
    }

    public boolean isMaisCaroQue(Pedido outroPedido) {
        return preco.compareTo(outroPedido.getPreco()) > 0;
    }

    public BigDecimal getValorTotal() {
        return preco.multiply(BigDecimal.valueOf(quantidade));
    }

    @Override
    public String toString() {
        return "Pedido" +
                "\n" + " Cliente:" + cliente.getPrimeiroNome() +
                "\n" + " Preco:" + preco +
                "\n" + " Valor Total:" + getValorTotal() +
                "\n" + " Data:" + data + "\n";
    }

}