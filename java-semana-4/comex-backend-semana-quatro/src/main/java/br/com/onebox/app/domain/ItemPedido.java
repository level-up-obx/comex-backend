package br.com.onebox.app.domain;

import java.math.BigDecimal;
import java.util.List;

public class ItemPedido {
    private Produto produto;
    private Pedido pedido;
    private BigDecimal precoUnitario = BigDecimal.ZERO;
    private int quantidade;
    private BigDecimal desconto;
    private TipoDescontoProdutoEnum tipoDesconto;

    public ItemPedido(Produto produto, Pedido pedido, BigDecimal precoUnitario, int quantidade, BigDecimal desconto, TipoDescontoProdutoEnum tipoDesconto) {
        this.produto = produto;
        this.pedido = pedido;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.tipoDesconto = tipoDesconto;
    }

    public Produto getProduto() {
        return produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public TipoDescontoProdutoEnum getTipoDesconto() {
        return tipoDesconto;
    }

    public BigDecimal getTotal(List<ItemPedido> itensComDesconto) {
        return itensComDesconto.stream()
                .map(item -> {
                    BigDecimal valorCompra = item.getTotal(itensComDesconto);
                    if(itensComDesconto.contains(item)) {
                        if (tipoDesconto == TipoDescontoProdutoEnum.QUANTIDADE) {
                            valorCompra = valorCompra.subtract(desconto.multiply(BigDecimal.valueOf(quantidade)));
                        }
                        if (tipoDesconto == TipoDescontoProdutoEnum.PROMOCAO){
                            valorCompra = valorCompra.subtract(desconto);
                        }
                    }
                    return valorCompra;
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
      }
    }

