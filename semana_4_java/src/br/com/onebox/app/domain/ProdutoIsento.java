package br.com.onebox.app.domain;

import java.math.BigDecimal;

public class ProdutoIsento extends Produto {

    public ProdutoIsento(int id,
                         String nome,
                         String descricao,
                         BigDecimal precoUnitario,
                         int quantidadeEstoque,
                         Categoria categoria) {
        super(id, nome, descricao, precoUnitario, quantidadeEstoque, categoria);
    }


    public BigDecimal impostoIsento() {
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal calculaImposto(BigDecimal precoUnitario) {
        return impostoIsento();
    }



}
