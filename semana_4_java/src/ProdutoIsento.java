import java.math.BigDecimal;
public class ProdutoIsento extends Produto {

    public ProdutoIsento(int id,
                         String nome,
                         String descricao,
                         BigDecimal precoUnitario,
                         int quantidadeEstoque,
                         String categoria) {
        super(id, nome, descricao, precoUnitario, quantidadeEstoque, categoria);
    }

    public BigDecimal calculaImposto() {
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal calculaValorTotalEstoque(BigDecimal precoUnitario,
                                               int quantidadeEstoque) {
        return super.calculaValorTotalEstoque(precoUnitario, quantidadeEstoque);
    }
}
