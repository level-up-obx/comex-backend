import java.math.BigDecimal;

public class ProdutoIsento {
    public static Long idAutoIncrementado = 0L;
    Long id;
    String nome;
    String descricao;
    BigDecimal precoUnitario;
    int quantidadeEmEstoque;
    Categoria categoria;

    public static BigDecimal calculaValorEstoque(BigDecimal precoUnitario, int quantidadeEmEstoque){
        return precoUnitario.multiply(BigDecimal.valueOf(quantidadeEmEstoque));
    }

    public static BigDecimal isentaImposto(BigDecimal precoUnitario){
        return precoUnitario.multiply(BigDecimal.valueOf(0));
    }

    }
