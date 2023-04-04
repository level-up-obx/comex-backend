package br.com.onebox.app.api.produto;

import br.com.onebox.app.api.categoria.CategoriaDto;
import br.com.onebox.app.domain.Produto;
import br.com.onebox.app.repository.CategoriaRepository;

import java.math.BigDecimal;

public class ProdutoForm {

    private Long id;
    private String nome;
    private BigDecimal preco;
    private String descricao;
    private Integer quantidadeEmEstoque;
    private CategoriaDto categoria;

    public Produto toEntity(CategoriaRepository categoriaRepository){
        return new Produto(id, nome, preco ,quantidadeEmEstoque, categoria.converter(categoriaRepository));
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
