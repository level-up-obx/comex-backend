package br.com.onebox.app.dtos;

import br.com.onebox.app.domain.TipoDescontoProdutoEnum;

import java.math.BigDecimal;

public class ItemPedidoDTO {
    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    private Long idProduto;
    private int quantidade;
}
