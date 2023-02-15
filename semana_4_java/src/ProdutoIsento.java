import java.math.BigDecimal;
public class ProdutoIsento extends Produto {

    public ProdutoIsento(int id,
                         String nome,
                         String descricao,
                         BigDecimal precoUnitario,
                         int quantidadeEstoque,
                         Categoria categoria) {
        super(id, nome, descricao, precoUnitario, quantidadeEstoque, categoria);
    }


    public BigDecimal impostoIsento() {
        return BigDecimal.ZERO;
    }

    public void produtoIsento() {
        System.out.println("Imposto: R$" + impostoIsento());
    }
}
