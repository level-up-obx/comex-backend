public class ProdutoIsento extends Produto{


    @Override
    public double getPrecoUnitario() {
        double isento = 0.0;
        return super.getPrecoUnitario() * isento;
    }
}