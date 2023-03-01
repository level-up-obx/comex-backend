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
	
	@Override
	public String toString() 
	{
		 return  "Nome: " + this.getNome() + "\n" +
				 "Categoria: " + this.getCategoria() + "\n" +
				 "Preco unitario: R$ " + this.getPrecoUnitario() + "\n" +
				 "Valor Total em Estoque: R$ " + ValorTotalEstoque(this.getPrecoUnitario(), this.getQuantidadeEstoque())+ "\n" +
				 "Valor imposto: R$ " + CalculaImposto(this.getPrecoUnitario()) + "\n";
	}
	
	

}
