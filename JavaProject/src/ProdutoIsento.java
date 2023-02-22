public class ProdutoIsento extends Produto {


    public ProdutoIsento(int id, String nome, String descricao, double precoUnitario, int quantidadeEstoque, String categotia) {
        super(id, nome, descricao, precoUnitario, quantidadeEstoque, categotia);
    }

    @Override
    public double getPrecoUnitario() {
        return super.getPrecoUnitario() * 0;
    }
}
