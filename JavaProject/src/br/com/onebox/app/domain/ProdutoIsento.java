package br.com.onebox.app.domain;

public class ProdutoIsento extends Produto  {


    public ProdutoIsento(int id, String nome, String descricao, double precoUnitario, int quantidadeEstoque, String categotia) throws Exception {
        super(id, nome, descricao, precoUnitario, quantidadeEstoque, categotia);
    }


}
