import java.math.BigDecimal;
import java.math.RoundingMode;

public class TestaProdutoIsento {
    public static void main(String[] args) {

        Categoria categoria1 = new Categoria(1, "SAÚDE", Boolean.TRUE);
        Categoria categoria2 = new Categoria(2, "LIVROS", Boolean.FALSE);
        Categoria categoria3 = new Categoria(3, "INFORMÁTICA", Boolean.TRUE);


        ProdutoIsento produto1 = new ProdutoIsento(1, "Vacina", "Vacina covid", new BigDecimal("250.00"), 1000, categoria1);
        ProdutoIsento produto2 = new ProdutoIsento(2, "Use a Cabeça: Java", "Livro: Use a Cabeça: Java", new BigDecimal("112.90"), 5, categoria2);
        Produto produto3 = new Produto(3, "Macbook Pro", "MacbookPro-computador", new BigDecimal("20000.00"), 11, categoria3);


        System.out.println("--------- PRODUTO - 1 ----------");
        System.out.println("Nome: " + produto1.getNome());
        System.out.println("Categoria: " + produto1.getCategoria());
        System.out.println("Preço Unitário: R$" + produto1.getPrecoUnitario());
        System.out.println("Quantidade em Estoque: " + produto1.getQuantidadeEstoque());
        System.out.println("Valor Total em Estoque: R$" + produto1.calculaValorTotalEstoque().setScale(2, RoundingMode.HALF_UP).toString());
        System.out.println("Imposto: R$" + produto1.calculaImposto(produto1.getPrecoUnitario()));

        System.out.println("--------- PRODUTO - 2 ----------");
        System.out.println("Nome: " + produto2.getNome());
        System.out.println("Categoria: " + produto2.getCategoria());
        System.out.println("Preço Unitário: R$" + produto2.getPrecoUnitario());
        System.out.println("Quantidade em Estoque: " + produto2.getQuantidadeEstoque());
        System.out.println("Valor Total em Estoque: R$" + produto2.calculaValorTotalEstoque().setScale(2, RoundingMode.HALF_UP).toString());
        System.out.println("Imposto: R$" + produto2.calculaImposto(produto2.getPrecoUnitario()));

        System.out.println("--------- PRODUTO - 3 ----------");
        System.out.println("Nome: " + produto3.getNome());
        System.out.println("Categoria: " + produto3.getCategoria());
        System.out.println("Preço Unitário: R$" + produto3.getPrecoUnitario());
        System.out.println("Quantidade em Estoque: " + produto3.getQuantidadeEstoque());
        System.out.println("Valor Total em Estoque: R$" + produto3.calculaValorTotalEstoque().setScale(2, RoundingMode.HALF_UP).toString());
        System.out.println("Imposto: R$" + produto3.calculaImposto(produto3.getPrecoUnitario()));
        ;

    }
}