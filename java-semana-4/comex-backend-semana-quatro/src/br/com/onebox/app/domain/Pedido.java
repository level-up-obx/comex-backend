package br.com.onebox.app.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

public class Pedido {
    private static Long idAutoIncrementado = 0L;
    private Long id;
    private Cliente cliente;
    private BigDecimal preco;
    private int quantidade;
    private LocalDate data;

    public Pedido(Cliente cliente, BigDecimal preco, int quantidade, LocalDate data) {
        this.cliente = cliente;
        this.preco = preco;
        this.quantidade = quantidade;
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public LocalDate getData() {
        return data;
    }

    public BigDecimal getValorTotal(){
        return preco.multiply(BigDecimal.valueOf(quantidade));
    }
    @Override
    public String toString() {
        return "Cliente: " + cliente.getPrimeiroNome() +
                " " + cliente.getSobrenome() +
                ", Preço: " + preco +
                ", Data: " + data +
                " e Valor Total: " + getValorTotal();
    }
}
