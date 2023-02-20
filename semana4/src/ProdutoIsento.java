import java.math.BigDecimal;

public class ProdutoIsento extends Produto {

	public ProdutoIsento(int id, String nome, String descricao, BigDecimal precoUnitario, int quantidadeEstoque,
			String categoria) 
	{
		
		super(id, nome, descricao, precoUnitario, quantidadeEstoque, categoria);
		
	}
	
	@Override
	public BigDecimal ValorTotalEstoque(BigDecimal precoUnitario, int quantidadeEstoque)
	{
		return super.ValorTotalEstoque(precoUnitario, quantidadeEstoque);
	}
	
	public BigDecimal calculaImposto()
	{
		return BigDecimal.ZERO;
	}
	
	

}
