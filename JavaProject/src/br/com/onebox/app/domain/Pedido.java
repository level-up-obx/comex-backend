package br.com.onebox.app.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pedido")

public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static int id;

    private String produto;

    @ManyToOne
    private String cliente;
    private double preco;
    private int quantidade;

    @Column(length = 9, nullable = false)
    private LocalDate data ;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens;
@Column(name="desconto",length = 3,nullable = false)
    private BigDecimal Desconto;

@Enumerated(EnumType.STRING)
    private TipoDeDescontoPedidoEnum TipoDeDesconto;


    public int getId() {
        return id;
    }


    public String getProduto() {
        return produto;
    }

    public String getCliente() {
        return cliente;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

//    public LocalDate getData() {
//        return data;
//    }

    @Override
    public String toString() {
        return " ---------- Pedido------------- " + "\n" + ++id + " - " +
                "produto = " + produto +
                " - cliente = " + cliente +
                " - preco = " + preco +
                " - data = " + data +
                " - quantidade = " + quantidade +
                '\'';
    }


    public Pedido(String produto, String cliente, double preco, int quantidade, LocalDate data) {

        this.cliente = cliente;
        this.preco = preco;
        this.quantidade = quantidade;
        this.data = data;
        this.produto = produto;


    }

    public static int pedidoid() {
        id = ++id;
        return ++id;

    }

    public boolean isMaisBaratoQue(Pedido outroPedido) {


        return this.getValorTotal().compareTo(outroPedido.getValorTotal()) < 0;
    }

    public boolean isMaisCaroQue(Pedido outroPedido) {

        return this.getValorTotal().compareTo(outroPedido.getValorTotal()) > 0;
    }

    public BigDecimal getValorTotal(){
        BigDecimal valorTotal = BigDecimal.ZERO;
        for(ItemPedido item : this.itens){
            valorTotal = valorTotal.add(item.getTotal());
        }
        return valorTotal;
    }


    public void adicionarItem(ItemPedido item){
        item.setPedido(this);
        this.itens.add(item);
    }
}

