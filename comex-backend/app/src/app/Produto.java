package app;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Produto {

	private static Long produtoId = 0L;
	private Long id = produtoId++;
	private String nome;
	private String descricao;
	private Double precoUnitario;
	private static BigDecimal imposto = new BigDecimal(0.40);
	private Long quantidadeEstoque;
	private Categoria categoria;
	
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
	
	

	public Double valorTotalEstoque() {
		return this.precoUnitario * this.quantidadeEstoque;
	}
	
	public BigDecimal calculaImposto() {
		return new BigDecimal(this.precoUnitario).multiply(imposto).setScale(2, RoundingMode.HALF_UP);
	}
}

