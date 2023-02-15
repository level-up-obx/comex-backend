import java.math.BigDecimal;

public class Estoque {
    private int capacidade = 1000;
    private int ocupacao;
    private BigDecimal montante = BigDecimal.ZERO;

    public Estoque(int capacidade) {
        this.capacidade = capacidade;
        this.ocupacao = 0;
        this.montante = BigDecimal.ZERO;
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

    public void registraEntrada(Produto produto) {
        if (produto.getQuantidadeEstoque() > 0) {
            int quantidade = produto.getQuantidadeEstoque();
            if (ocupacao + quantidade > capacidade) {
                System.out.println("Estoque cheio");
                return;
            }
            ocupacao += quantidade;
            montante = montante.add(produto.calculaValorTotalEstoque());
        }
    }

    public void registraSaida(Produto produto) {
        if (produto.getQuantidadeEstoque() > 0) {
            int quantidade = produto.getQuantidadeEstoque();
            if (ocupacao - quantidade < 0) {
                System.out.println("Estoque insuficiente");
                return;
            }
            ocupacao -= quantidade;
            montante = montante.subtract(produto.calculaValorTotalEstoque());
        }
    }
}
