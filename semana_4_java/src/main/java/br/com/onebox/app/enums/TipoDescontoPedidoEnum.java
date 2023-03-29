package br.com.onebox.app.enums;

import java.math.BigDecimal;

public enum TipoDescontoPedidoEnum {
    FIDELIDADE {
        public BigDecimal getDesconto() {
            return new BigDecimal("0.05");
        }
    },
    NENHUM {
        public BigDecimal getDesconto() {
            return BigDecimal.ZERO;
        }
    };

    public abstract BigDecimal getDesconto();
}




