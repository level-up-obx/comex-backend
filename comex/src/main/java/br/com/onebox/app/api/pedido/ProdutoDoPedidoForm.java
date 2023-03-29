package br.com.onebox.app.api.pedido;

public class ProdutoDoPedidoForm {

    private Long id;
    private Integer quantidadeDeItens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidadeDeItens() {
        return quantidadeDeItens;
    }

    public void setQuantidadeDeItens(Integer quantidadeDeItens) {
        this.quantidadeDeItens = quantidadeDeItens;
    }
}
