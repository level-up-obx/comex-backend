package br.com.onebox.app.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 9, nullable = false)
    private LocalDateTime data;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens = new ArrayList<>();

    @Column(precision = 15, scale = 2, nullable = false)
    private BigDecimal desconto = BigDecimal.ZERO;

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

    public Pedido(List<ItemPedido> itens, Cliente cliente) {
        adicionarItens(itens);
        this.cliente = cliente;
        this.data = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public int getTotalItens(){
        int quantidadeTotalDeItens = 0;
        for(ItemPedido item : this.itens){
            quantidadeTotalDeItens = item.getQuantidade() + quantidadeTotalDeItens;
        }
        return quantidadeTotalDeItens;
    }
    public void getDescontoDoPedido(){
        if(this.tipoDescontoPedidoEnum.equals(TipoDescontoPedidoEnum.NENHUM)){
            this.desconto = new BigDecimal("1.0");
        } this.desconto = new BigDecimal("0.9");
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
    public void adicionarItens(List<ItemPedido> itens){
        itens.forEach(item ->{
            item.setPedido(this);
            this.itens.add(item);
        });
    }
}
