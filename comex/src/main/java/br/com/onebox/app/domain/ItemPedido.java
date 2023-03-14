package br.com.onebox.app.domain;

import java.math.BigDecimal;

public class ItemPedido {
    private Produto produto;
    private Pedido pedido;
    private BigDecimal precoUnitario;
    private int quantidade;
    private BigDecimal desconto;
    private TipoDescontoProdutoEnum tipoDesconto;

    public BigDecimal getTotal(){
        return this.precoUnitario.multiply(new BigDecimal(quantidade)).multiply(desconto);
    }
}
