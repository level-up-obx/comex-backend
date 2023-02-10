package app;

public class Produto {

	Long id;
	String nome;
	String descricao;
	Float precoUnitario;
	Long quantidadeEstoque;
	String categoria;
	
	public Long getId() { return this.id;}
	public String getNome() { return this.nome;}
	public String getDescricao() { return this.descricao;}
	public Float getPrecoUnitario() { return this.precoUnitario;}
	public Long getQuantidadeEstoque() { return this.quantidadeEstoque;}
	public String getCategoria() { return this.categoria;}
	
	public Long setId(Long id) { return this.id = id;}
	public String setNome(String nome) { return this.nome = nome;}
	public String setDescricao(String descricao) { return this.descricao = descricao;}
	public Float setPrecoUnitario(Float precoUnitario) { return this.precoUnitario = precoUnitario;}
	public Long setQuantidadeEstoque(Long quantidadeEstoque) { return this.quantidadeEstoque = quantidadeEstoque;}
	public String setCategoria(String categoria) { return this.categoria = categoria;}
	
	public Float calculaValorTotalEstoque() {
		return this.precoUnitario * this.quantidadeEstoque;
	}
	
	public Float calculaImposto() {
		return (float) (this.precoUnitario * 0.4);
	}
}

