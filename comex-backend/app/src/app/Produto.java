package app;

public class Produto {

	Long id;
	String nome;
	String descricao;
	Double precoUnitario;
	Long quantidadeEstoque;
	Categoria categoria;
	
	public Long getId() { return this.id;}
	public String getNome() { return this.nome;}
	public String getDescricao() { return this.descricao;}
	public Double getPrecoUnitario() { return this.precoUnitario;}
	public Long getQuantidadeEstoque() { return this.quantidadeEstoque;}
	public Categoria getCategoria() { return this.categoria;}
	
	public Long setId(Long id) { return this.id = id;}
	public String setNome(String nome) { return this.nome = nome;}
	public String setDescricao(String descricao) { return this.descricao = descricao;}
	public Double setPrecoUnitario(Double precoUnitario) { return this.precoUnitario = precoUnitario;}
	public Long setQuantidadeEstoque(Long quantidadeEstoque) { return this.quantidadeEstoque = quantidadeEstoque;}
	public Categoria setCategoria(Categoria categoria) { return this.categoria = categoria;}
	
	public Double calculaValorTotalEstoque() {
		return this.precoUnitario * this.quantidadeEstoque;
	}
	
	public Double calculaImposto() {
		return (Double) (this.precoUnitario * 0.4);
	}
}

