package br.com.onebox.app.domain;

import br.com.onebox.app.domain.Categoria;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Produto {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal precoUnitario;
    private Integer quantidadeEmEstoque;
    private Categoria categoria;

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
        if (precoUnitario.compareTo(BigDecimal.ZERO) <= 0){
            throw new PrecoInvalidoException("O preço do produto não pode ser menor ou igual a zero");
        }
        this.precoUnitario = precoUnitario;
    }

    public Integer getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(Integer quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public BigDecimal calculaValorTotalEmEstoque() {
        return this.precoUnitario.multiply(new BigDecimal(this.quantidadeEmEstoque)).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculaImposto() {
        return this.precoUnitario.multiply(new BigDecimal("0.4")).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return  "id = " + id +
                ", nome = '" + nome + '\'' +
                ", descricao = '" + descricao + '\'' +
                ", precoUnitario = R$" + precoUnitario +
                ", quantidadeEmEstoque = " + quantidadeEmEstoque;
    }

    public String toStringSemDescricao() {
        return  "id: " + id +
                ", nome: '" + nome + '\'' +
                ", precoUnitario: R$" + precoUnitario +
                ", quantidadeEmEstoque: " + quantidadeEmEstoque;
    }

    public Produto(Long id, String nome, String descricao, BigDecimal precoUnitario, Integer quantidadeEmEstoque, Categoria categoria) {
        this.id = GeradorDeId.proximoId();
        this.nome = nome;
        this.descricao = descricao;
        if (precoUnitario.compareTo(BigDecimal.ZERO) <= 0){
            throw new PrecoInvalidoException("O preço do produto não pode ser menor ou igual a zero");
        }
        this.precoUnitario = precoUnitario;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.categoria = categoria;
    }

    public Produto(Long id, String nome, BigDecimal precoUnitario, Integer quantidadeEmEstoque, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        if (precoUnitario.compareTo(BigDecimal.ZERO) <= 0){
            throw new PrecoInvalidoException("O preço do produto não pode ser menor ou igual a zero");
        }
        this.precoUnitario = precoUnitario;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.categoria = categoria;
    }

    public Produto(){
        this.id = GeradorDeId.proximoId();
        if (precoUnitario.compareTo(BigDecimal.ZERO) <= 0){
            throw new PrecoInvalidoException("O preço do produto não pode ser menor ou igual a zero");
        }
    }
}
