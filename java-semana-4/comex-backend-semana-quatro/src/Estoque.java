import java.math.BigDecimal;

public class Estoque {
    private int capacidade = 1000;
    private int ocupacao = 0;
    private BigDecimal montante = BigDecimal.ZERO;

   public void registrarEntrada(Produto produto){
       int quantidade = produto.getQuantidadeEmEstoque();
       BigDecimal valorTotal = produto.getPrecoUnitario().multiply(new BigDecimal(quantidade));
       this.capacidade -= quantidade;
       this.ocupacao += quantidade;
       this.montante = this.montante.add(valorTotal);
   }

   public void registrarSaida(Produto produto){
       int quantidade = produto.getQuantidadeEmEstoque();
       BigDecimal valorTotal = produto.getPrecoUnitario().multiply(new BigDecimal(quantidade));
       this.capacidade += quantidade;
       this.ocupacao -= quantidade;
       this.montante = this.montante.subtract(valorTotal);
   }

    public int getCapacidade() {
        return capacidade;
    }

    public int getOcupacao() {
        return ocupacao;
    }

    public BigDecimal getMontante() {
        return montante;
    }
}
