public class ProdutoIsento extends Produto {

    public ProdutoIsento(String nome, String descricao, double precoUnitario, int quantidadeEstoque, String categotia) {
        super(nome, descricao, precoUnitario, quantidadeEstoque, categotia);


    }

    @Override
    public double getPrecoUnitario() {
        return super.getPrecoUnitario() * 0;
    }
}
