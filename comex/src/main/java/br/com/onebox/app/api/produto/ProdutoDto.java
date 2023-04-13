package br.com.onebox.app.api.produto;

import br.com.onebox.app.api.categoria.CategoriaDto;
import br.com.onebox.app.domain.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.Optional;

public class ProdutoDto {

    @NotNull @NotBlank
    private Long id;

    @NotNull @NotBlank @Size(min = 2)
    private String nome;

    @NotNull @NotBlank
    private BigDecimal preco;

    private String descricao;

    @NotNull @NotBlank
    private Integer quantidadeEmEstoque;

    private CategoriaDto categoria;

    public ProdutoDto(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPrecoUnitario();
        this.descricao = produto.getDescricao();
        this.quantidadeEmEstoque = produto.getQuantidadeEmEstoque();
        this.categoria = new CategoriaDto(produto.getCategoria());
    }
    public void toEntity(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPrecoUnitario();
        this.descricao = produto.getDescricao();
        this.quantidadeEmEstoque = produto.getQuantidadeEmEstoque();
        this.categoria = new CategoriaDto(produto.getCategoria());
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(Integer quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public CategoriaDto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDto categoria) {
        this.categoria = categoria;
    }
}
