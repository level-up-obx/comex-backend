import java.math.BigDecimal;

public class ProdutoIsento extends Produto{

    public BigDecimal calculaImposto(){
        return BigDecimal.ZERO;
    }

    public ProdutoIsento(Long id, String nome, BigDecimal precoUnitario, Integer quantidadeEmEstoque, Categoria categoria) {
        super.setId(id);
        super.setNome(nome);
        super.setPrecoUnitario(precoUnitario);
        super.setQuantidadeEmEstoque(quantidadeEmEstoque);
        super.setCategoria(categoria);
    }

    public ProdutoIsento() {
    }
}
