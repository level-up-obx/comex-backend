import java.math.BigDecimal;

public class TestaProdutoIsento {
    public static void main(String[] args) {

        Categoria categoria1 = new Categoria("Saúde");
        Categoria categoria2 = new Categoria("Livros");
        Categoria categoria3 = new Categoria("Informática");
        ProdutoIsento produtoIsento1 = new ProdutoIsento("Vacina", new BigDecimal("250.00"), 1000, categoria1 );
        ProdutoIsento produtoIsento2 = new ProdutoIsento("Use a Cabeça: Java", new BigDecimal("112.90"), 5, categoria2);
        ProdutoIsento produto3 = new ProdutoIsento("Macbook Pro", new BigDecimal("20000.00"), 11, categoria3);

        produtoIsento1.produtoIsento();
        System.out.println(" e categoria: " + categoria1.getNome() + "." + "\n");
        produtoIsento2.produtoIsento();
        System.out.println(" e categoria: " + categoria2.getNome() + "." + "\n");
        System.out.println(produto3 + " e categoria: " + categoria3.getNome() + "." + "\n");

    }

}
