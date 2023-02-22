public class Estoque {

    private int capacidade = 1000;
    private int ocupacao;
    private double montante ;

     public void registraEntrada(Produto produto) {
         this.capacidade = capacidade - produto.getQuantidadeEstoque();
         this.ocupacao = ocupacao + produto.getQuantidadeEstoque();
         this.montante = montante + produto.getValorEstoque();


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
        return "Estoque{" +
                "capacidade=" + capacidade +
                ", ocupacao=" + ocupacao +
                ", montante=" + montante +
                '}';
    }
}
