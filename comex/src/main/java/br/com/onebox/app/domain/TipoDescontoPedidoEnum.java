package br.com.onebox.app.domain;

import java.math.BigDecimal;

public enum TipoDescontoPedidoEnum {
    FIDELIDADE(0.95),
    NENHUM(1);

    private final double desconto;

    TipoDescontoPedidoEnum(double desconto) {
        this.desconto = desconto;
    }
}
