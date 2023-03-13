package br.com.onebox.app.domain;

import java.math.BigDecimal;

public class ItemPedido {
    Produto produto;
    Pedido pedido;
    BigDecimal precoUnitario;
    int quantidade;
    BigDecimal desconto;
    TipoDescontoProdutoEnum tipoDesconto;

    public BigDecimal getTotal(){
        return this.precoUnitario.multiply(new BigDecimal(quantidade)).multiply(desconto);
    }
}
