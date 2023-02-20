import java.math.BigDecimal;

public class Produto {
	
	private int id;
	private String nome;
    private String descricao;
    private BigDecimal precoUnitario;
    private int quantidadeEstoque;
    private String categoria;

    public Produto(int id, String nome, String descricao, BigDecimal precoUnitario, int quantidadeEstoque, String categoria) 
    {
        this.id = ++id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
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

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
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
}
