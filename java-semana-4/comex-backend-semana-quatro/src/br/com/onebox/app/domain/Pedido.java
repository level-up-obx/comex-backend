package br.com.onebox.app.domain;
import java.math.BigDecimal;
import java.time.LocalDate;

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

    public boolean isMaisBaratoQue(Pedido outroPedido){
        BigDecimal valorTotal = this.getValorTotal();
        BigDecimal valorTotal2 = outroPedido.getValorTotal();
        return valorTotal.compareTo(valorTotal2) < 0;
    }

    public boolean isMaisCaroQue(Pedido outroPedido){
        BigDecimal valorTotal = this.getValorTotal();
        BigDecimal valorTotal2 = outroPedido.getValorTotal();
        return valorTotal.compareTo(valorTotal2) > 0;
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
