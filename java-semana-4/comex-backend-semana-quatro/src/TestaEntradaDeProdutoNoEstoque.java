import java.math.BigDecimal;

public class TestaEntradaDeProdutoNoEstoque {

    public static void main(String[] args) {

        Categoria categoria1 = new Categoria("Saúde");
        Categoria categoria2 = new Categoria("Livros");
        Categoria categoria3 = new Categoria("Informática");
        ProdutoIsento produtoIsento1 = new ProdutoIsento("Vacina", new BigDecimal("250.00"), 500, categoria1 );
        ProdutoIsento produtoIsento2 = new ProdutoIsento("Use a Cabeça: Java", new BigDecimal("112.90"), 5, categoria2);
        Produto produto3 = new Produto("Macbook Pro", new BigDecimal("20000.00"), 15, categoria3);

        Estoque estoque = new Estoque();

        estoque.registrarEntrada(produtoIsento1);
        estoque.registrarEntrada(produtoIsento2);
        estoque.registrarEntrada(produto3);

        System.out.println("Capacidade do estoque: " + estoque.getCapacidade());
        System.out.println("Ocupação do estoque: " + estoque.getOcupacao());
        System.out.println("Montante financeiro do estoque: " + estoque.getMontante());

    }

}
