package br.com.onebox.app.domain;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
@Table(name = "produto")
public class Produto {

    private static final BigDecimal VALOR_DO_IMPOSTO = new BigDecimal("0.40");
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String nome;
    @Column(length = 255)
    private String descricao;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precoUnitario;
    @Max(1000)
    @Column(nullable = false)
    private int quantidadeEmEstoque;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    private void tratamentoDeErroPrecoUnitario(BigDecimal precoUnitario) throws Exception{
        try{
            if (precoUnitario.compareTo(BigDecimal.ZERO) == 0){
                throw new Exception("O produto está com valor zerado.");
            }
            if(precoUnitario.compareTo(BigDecimal.ZERO) < 0){
                throw new Exception("O produto está com valor negativo.");
            }
        } catch (Exception e){
            System.out.println("Ocorreu o seguinte erro: " + e.getMessage());
            throw e;
        }
    }
    public Produto(String nome, BigDecimal precoUnitario, int quantidadeEmEstoque, Categoria categoria) throws Exception {
        tratamentoDeErroPrecoUnitario(precoUnitario);
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.categoria = categoria;
    }

    public Produto(String nome, BigDecimal precoUnitario) throws Exception {
        tratamentoDeErroPrecoUnitario(precoUnitario);
        this.nome = nome;
        this.precoUnitario = precoUnitario;
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

    public void setPrecoUnitario(BigDecimal precoUnitario) throws Exception {
        tratamentoDeErroPrecoUnitario(precoUnitario);
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
        BigDecimal valorEstoque = calculaValorEstoque();
        BigDecimal imposto = valorEstoque.multiply(VALOR_DO_IMPOSTO).setScale(2, RoundingMode.HALF_UP);
        return imposto;
    }

    @Override
    public String toString() {
        return  "br.com.onebox.app.domain.Produto " + id + " - " + nome + ", Preço unitário: " + precoUnitario +
                ", quantidade em estoque: " + quantidadeEmEstoque +
                ", valor total em estoque: " + calculaValorEstoque() +
                ", valor do imposto: " + calculaImposto();
    }
}
