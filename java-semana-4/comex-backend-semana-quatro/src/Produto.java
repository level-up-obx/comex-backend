import java.math.BigDecimal;
public class Produto {

    Long id;

    String nome;

    String descricao;

    BigDecimal precoUnitario;

    int quantidadeEmEstoque;

    Categoria categoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public static BigDecimal calculaValorEstoque(BigDecimal precoUnitario, int quantidadeEmEstoque){
        return precoUnitario.multiply(BigDecimal.valueOf(quantidadeEmEstoque));
    }

    public static BigDecimal calculaImposto(BigDecimal precoUnitario){
        return precoUnitario.multiply(BigDecimal.valueOf(0.4));
    }

    @Override
    public String toString() {
        return  "Produto " + id + " - " + nome + ", Preço unitário: " + precoUnitario +
                ", quantidade em estoque: " + quantidadeEmEstoque +
                ", valor total em estoque: " + calculaValorEstoque(precoUnitario, quantidadeEmEstoque) +
                ", valor do imposto: " + calculaImposto(precoUnitario);
    }
}
