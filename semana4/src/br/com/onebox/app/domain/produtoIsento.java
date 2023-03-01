package br.com.onebox.app.domain;


import java.math.BigDecimal;

public class produtoIsento extends Produto {

	public produtoIsento(int id, String nome, String descricao, BigDecimal precoUnitario, int quantidadeEstoque,
			Categoria categoria) 
	{
		
		super(id, nome, descricao, precoUnitario, quantidadeEstoque, categoria);
		
	}
	
	@Override
	public BigDecimal ValorTotalEstoque(BigDecimal precoUnitario, int quantidadeEstoque)
	{
		return super.ValorTotalEstoque(precoUnitario, quantidadeEstoque);
	}
	
	public BigDecimal ImpostoIsento()
	{
		return BigDecimal.ZERO;
	}
	
	

}
