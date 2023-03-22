package br.com.onebox.app.domain;

public class Estoque {

    private int capacidade = 1000;
    private int ocupacao;
    private double montante ;

     public void registraEntrada(Produto produto) {
         this.capacidade = capacidade - produto.getQuantidadeEstoque();
         this.ocupacao = ocupacao + produto.getQuantidadeEstoque();
         this.montante = montante + produto.getValorEstoque();


    }
    public void registrSaida(Produto produto1) {
        this.capacidade = capacidade + produto1.getQuantidadeEstoque();
        this.ocupacao = ocupacao - produto1.getQuantidadeEstoque();
        this.montante = montante - produto1.getValorEstoque();


    }




        public int getCapacidade() {
        return capacidade ;
    }

    public int getOcupacao() {
        return ocupacao ;
    }

    public double getMontante() {
        return montante ;
    }

    @Override
    public String toString() {
        return "br.com.onebox.app.domain.Estoque{" +
                "capacidade=" + capacidade +
                ", ocupacao=" + ocupacao +
                ", montante=" + montante +
                '}';
    }
}
