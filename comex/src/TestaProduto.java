import java.math.BigDecimal;

public class TestaProduto {

    public static void quebraLinha(){
        System.out.println("-".repeat(90));
    }

    public static void main(String[] args) {

        Produto produto1 = new Produto();
        Produto produto2 = new Produto();
        Produto produto3 = new Produto();
        Categoria informatica = new Categoria();
        informatica.setNome("INFORMÁTICA");
        Categoria livros = new Categoria();
        livros.setNome("LIVROS");

        produto1.setId(1L);
        produto1.setNome("Notebook Samsung");
        produto1.setPrecoUnitario(new BigDecimal("3523.00"));
        produto1.setQuantidadeEmEstoque(1);
        produto1.setCategoria(informatica);

        produto2.setId(2L);
        produto2.setNome("Clean Architecture");
        produto2.setPrecoUnitario(new BigDecimal("102.90"));
        produto2.setQuantidadeEmEstoque(2);
        produto2.setCategoria(livros);

        produto3.setId(3L);
        produto3.setNome("Monitor Dell 27");
        produto3.setPrecoUnitario(new BigDecimal("1889.00"));
        produto3.setQuantidadeEmEstoque(3);
        produto3.setCategoria(informatica);

        System.out.println("Informações do produto 1:\n" + produto1.toStringSemDescricao() + "\nCategoria: " + produto1.getCategoria().getNome() + "\n" + "O valor total em estoque é: " + produto1.calculaValorTotalEmEstoque() + "\n" + "O valor do imposto é: " + produto1.calculaImposto());
        quebraLinha();
        System.out.println("Informações do produto 2:\n" + produto2.toStringSemDescricao() + "\nCategoria: " + produto2.getCategoria().getNome() + "\n" + "O valor total em estoque é: " + produto2.calculaValorTotalEmEstoque() + "\n" + "O valor do imposto é: " + produto2.calculaImposto());
        quebraLinha();
        System.out.println("Informações do produto 3:\n" + produto3.toStringSemDescricao() + "\nCategoria: " + produto3.getCategoria().getNome() + "\n" + "O valor total em estoque é: " + produto3.calculaValorTotalEmEstoque() + "\n" + "O valor do imposto é: " + produto3.calculaImposto());
        quebraLinha();
    }
}
