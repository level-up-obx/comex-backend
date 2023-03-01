package br.com.onebox.app.domain;

import java.math.BigDecimal;

public class Produto {
	
	private int id;
	private String nome;
    private String descricao;
    private BigDecimal precoUnitario;
    private int quantidadeEstoque;
    private Categoria categoria;

    public Produto(int id, String nome, String descricao, BigDecimal precoUnitario, int quantidadeEstoque, Categoria categoria) 
    {
        this.id = ++id;
        this.nome = nome;
        this.descricao = descricao;
        setPrecoUnitario(precoUnitario);
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
    }
    
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario)throws PrecoInvalidoException{
		
		if(precoUnitario.compareTo(BigDecimal.ZERO)<= 0) {
			throw new PrecoInvalidoException("Preco invalido! O preco unitario nao pode ser igual ou menor que zero.");
		}else {
			this.precoUnitario = precoUnitario;
		}
		
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public BigDecimal ValorTotalEstoque(BigDecimal precoUnitario, int quantidadeEstoque)
	{
		return precoUnitario.multiply(BigDecimal.valueOf(quantidadeEstoque));
	}

	public BigDecimal CalculaImposto(BigDecimal precoUnitario)
	{
		return precoUnitario.multiply(BigDecimal.valueOf(0.4));
	}
	@Override
	public String toString() 
	{
		 return  "Nome: " + nome + "\n" +
				 "Categoria: " + categoria + "\n" +
				 "Preco unitario: R$ " + precoUnitario + "\n" +
				 "Valor Total em Estoque: R$ " + ValorTotalEstoque(precoUnitario, quantidadeEstoque)+ "\n" +
				 "Valor imposto: R$ " + CalculaImposto(precoUnitario) + "\n";
	}
	
}
