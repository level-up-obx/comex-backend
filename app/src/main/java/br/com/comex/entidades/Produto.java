package br.com.comex.entidades;

import br.com.comex.entity.Categoria;
import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "Produto")
public class Produto {

	@Id
	private static Long produtoId = 0L;
	private Long id = produtoId++;
	@NotNull
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
			Categoria Categoria) throws Exception {

		setId();
		setNome(nome);
		setPrecoUnitario(precoUnitario);
		setQuantidadeEstoque(quantidadeEstoque);
		setCategoria(Categoria);

	}

	public Produto() {

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
	public br.com.comex.entity.Categoria setCategoria(Categoria Categoria) { return this.categoria = Categoria;}



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

