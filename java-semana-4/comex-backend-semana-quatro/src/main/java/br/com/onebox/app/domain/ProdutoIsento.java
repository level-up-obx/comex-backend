package br.com.onebox.app.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "produtoIsento")
public class ProdutoIsento extends Produto {
    public ProdutoIsento(String nome, BigDecimal precoUnitario, int quantidadeEmEstoque, Categoria categoria) throws Exception {
        super(nome, precoUnitario, quantidadeEmEstoque, categoria);
    }
    @Override
    public BigDecimal calculaImposto() {
        return BigDecimal.ZERO;
    }

}
