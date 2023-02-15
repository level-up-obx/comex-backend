import java.math.BigDecimal;

public class Estoque {

    private int capacidade = 1000;
    private int ocupacao;
    private BigDecimal montante;

    public int getCapacidade() {
        return capacidade;
    }

    public int getOcupacao() {
        return ocupacao;
    }

    public BigDecimal getMontante() {
        return montante;
    }

    public void registraEntrada(Produto produto){
        capacidade = this.capacidade - produto.getQuantidadeEmEstoque();
        ocupacao = this.ocupacao + produto.getQuantidadeEmEstoque();
        montante = this.montante.add(produto.calculaValorTotalEmEstoque());
    }

    public void registraSaida(Produto produto){
        capacidade = this.capacidade + produto.getQuantidadeEmEstoque();
        ocupacao = this.ocupacao - produto.getQuantidadeEmEstoque();
        montante = this.montante.subtract(produto.calculaValorTotalEmEstoque());
    }
}
