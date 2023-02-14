import java.math.BigDecimal;

public class ProdutoIsento extends Produto{
    
    public BigDecimal calculaImposto(){
        return BigDecimal.ZERO;
    }
}
