package br.com.onebox.app.api.pedido;

public class ProdutoItemDto {
    private Long id;
    private Integer quantidade;

    public ProdutoItemDto() {
    }

    public ProdutoItemDto(Long id, Integer quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
