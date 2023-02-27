package br.com.onebox.app.domain;

import java.math.BigDecimal;

public class Estoque {
    private int capacidade = 1000;
    private int ocupacao;
    private BigDecimal montante = BigDecimal.ZERO;

    private void tratamentoErroQuantidade(int quantidade){
        if (quantidade < 0){
            throw new RuntimeException("Valores negativos são inválidos para este negócio. Tente novamente.");
        }
        if (quantidade == 0){
            throw new RuntimeException("Não há produtos para realizar a movimentação.");
        }
    }

   public void registrarEntrada(Produto produto){
       int quantidade = produto.getQuantidadeEmEstoque();
       BigDecimal valorTotal = produto.getPrecoUnitario().multiply(new BigDecimal(quantidade));
       tratamentoErroQuantidade(quantidade);
       if (this.capacidade - quantidade < 0){
           throw new RuntimeException("Capacidade máxima do estoque atingida, não é possível adicionar mais produtos");
       }
       this.capacidade -= quantidade;
       this.ocupacao += quantidade;
       this.montante = this.montante.add(valorTotal);
   }

   public void registrarSaida(Produto produto){
       int quantidade = produto.getQuantidadeEmEstoque();
       BigDecimal valorTotal = produto.getPrecoUnitario().multiply(new BigDecimal(quantidade));
       tratamentoErroQuantidade(quantidade);
       this.capacidade += quantidade;
       this.ocupacao -= quantidade;
       this.montante = this.montante.subtract(valorTotal);
   }

   @Override
   public String toString(){
       return "A capacidade é: " + capacidade + ", a ocupação é: " + ocupacao + ", e o montante é: " + montante;
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
