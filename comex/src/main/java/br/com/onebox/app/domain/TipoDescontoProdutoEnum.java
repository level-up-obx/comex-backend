package br.com.onebox.app.domain;

import java.math.BigDecimal;

public enum TipoDescontoProdutoEnum {
    QUANTIDADE(0.9),
    PROMOCAO(0.8),
    NENHUM(1);

    private final double desconto;

    TipoDescontoProdutoEnum(double desconto) {
        this.desconto = desconto;
    }
}
