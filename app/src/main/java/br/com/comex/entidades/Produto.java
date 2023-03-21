package main.java.br.com.comex.entidades;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Produto {

	private static Long produtoId = 0L;
	private Long id = produtoId++;
	private String nome;
	private String descricao;
	private BigDecimal precoUnitario;
	private static BigDecimal imposto = new BigDecimal(0.40);
	private Long quantidadeEstoque;
	private Categoria categoria;
	private Boolean isento = Boolean.FALSE;

	public Produto(
			String nome,
			BigDecimal precoUnitario,
			Long quantidadeEstoque,
			Categoria categoria) throws Exception {

		setId();
		setNome(nome);
		setPrecoUnitario(precoUnitario);
		setQuantidadeEstoque(quantidadeEstoque);
		setCategoria(categoria);

	}

	public Long getId() { return this.id;}
	public String getNome() { return this.nome;}
	public String getDescricao() { return this.descricao;}
	public BigDecimal getPrecoUnitario() { return this.precoUnitario.setScale(2, RoundingMode.HALF_UP);}
	public Long getQuantidadeEstoque() { return this.quantidadeEstoque;}
	public Categoria getCategoria() { return this.categoria;}

	public Long setId() { return this.id =+ produtoId;}
	public String setNome(String nome) { return this.nome = nome;}
	public String setDescricao(String descricao) { return this.descricao = descricao;}
	public BigDecimal setPrecoUnitario(BigDecimal precoUnitario) throws Exception {

		if(nuloOuIgualAZero(precoUnitario))
			throw new Exception("Valor não pode ser nulo ou igual a 0");

			return this.precoUnitario = precoUnitario;
		}

	public Long setQuantidadeEstoque(Long quantidadeEstoque) { return this.quantidadeEstoque = quantidadeEstoque;}
	public Categoria setCategoria(Categoria categoria) { return this.categoria = categoria;}



	public BigDecimal valorTotalEstoque() {
		return this.precoUnitario.multiply(new BigDecimal(quantidadeEstoque)).setScale(2, RoundingMode.HALF_UP);
	}

	public BigDecimal calculaImposto() {
		if(this.isento.equals(Boolean.TRUE)) {
			return BigDecimal.ZERO;
		}
		return this.precoUnitario.multiply(imposto).setScale(2, RoundingMode.HALF_UP);
	}

	protected Boolean setIsento(Boolean isento) {
		return this.isento = isento;
	}

	private Boolean nuloOuIgualAZero(BigDecimal valorMonetario) {
		return (valorMonetario == null | valorMonetario.equals(new BigDecimal(0L)));
	}
}

