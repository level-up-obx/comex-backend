import java.math.BigDecimal;
import java.math.RoundingMode;

public class Produto {

    private static final BigDecimal VALOR_DO_IMPOSTO = new BigDecimal("0.40");
    private static Long idAutoIncrementado = 0L;
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal precoUnitario = BigDecimal.ZERO;
    private int quantidadeEmEstoque;
    Categoria categoria;

    public Produto(){
        this.id = ++idAutoIncrementado;
    }

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

    public BigDecimal calculaValorEstoque(){
        return this.precoUnitario.multiply(new BigDecimal(this.quantidadeEmEstoque).setScale(2, RoundingMode.HALF_UP));
    }

    public BigDecimal calculaImposto(){
        return this.precoUnitario.multiply(new BigDecimal("0.4").setScale(2, RoundingMode.HALF_UP));
    }

    @Override
    public String toString() {
        return  "Produto " + id + " - " + nome + ", Preço unitário: " + precoUnitario +
                ", quantidade em estoque: " + quantidadeEmEstoque +
                ", valor total em estoque: " + calculaValorEstoque() +
                ", valor do imposto: " + calculaImposto();
    }
}
