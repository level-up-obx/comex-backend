package br.com.onebox.app.domain;

import java.util.Comparator;

public class PedidoComparator implements Comparator<Pedido> {

    @Override
    public int compare(Pedido pedido1, Pedido pedido2) {
        return pedido1.getValorTotal().compareTo(pedido2.getValorTotal());
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

}
