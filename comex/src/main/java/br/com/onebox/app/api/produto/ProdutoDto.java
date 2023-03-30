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
}
