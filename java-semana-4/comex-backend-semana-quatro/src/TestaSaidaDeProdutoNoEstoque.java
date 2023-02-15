import java.math.BigDecimal;

public class TestaSaidaDeProdutoNoEstoque {
    public static void main(String[] args) {
        Categoria categoria1 = new Categoria("Saúde");
        ProdutoIsento produto1 = new ProdutoIsento("Vacina", new BigDecimal("250.00"), 500, categoria1);

        Estoque estoque = new Estoque();

        estoque.registrarEntrada(produto1);
        System.out.println("Dados do estoque: ");
        System.out.println(estoque);
        estoque.registrarSaida(produto1);
        System.out.println("Dados após saída do estoque: ");
        System.out.println(estoque);
    }

}
