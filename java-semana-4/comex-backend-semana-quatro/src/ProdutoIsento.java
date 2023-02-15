import java.math.BigDecimal;

public class ProdutoIsento extends Produto {
    public ProdutoIsento(String nome, BigDecimal precoUnitario, int quantidadeEmEstoque, Categoria categoria) {
        super(nome, precoUnitario, quantidadeEmEstoque, categoria);
    }
    public BigDecimal isentaImposto() {
        return BigDecimal.ZERO;
    }

    public void produtoIsento() {
        System.out.println("Produto " + getId() + " - " + getNome() + ", Preço unitário: " + getPrecoUnitario() +
                ", quantidade em estoque: " + getQuantidadeEmEstoque() +
                ", valor total em estoque: " + calculaValorEstoque() +
                ", valor do imposto: " + isentaImposto());
    }


}
