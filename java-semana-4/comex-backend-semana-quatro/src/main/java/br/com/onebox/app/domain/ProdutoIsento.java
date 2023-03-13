package br.com.onebox.app.domain;

import java.math.BigDecimal;

public class ProdutoIsento extends Produto {
    public ProdutoIsento(String nome, BigDecimal precoUnitario, int quantidadeEmEstoque, Categoria categoria) throws Exception {
        super(nome, precoUnitario, quantidadeEmEstoque, categoria);
    }
    @Override
    public BigDecimal calculaImposto() {
        return BigDecimal.ZERO;
    }

}
