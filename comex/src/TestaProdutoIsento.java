import java.math.BigDecimal;

public class TestaProdutoIsento {
    public static void main(String[] args) {
        ProdutoIsento vacina = new ProdutoIsento(1L, "Vacina", new BigDecimal("250.00"), 1000, new Categoria("Saúde"));
        ProdutoIsento useACabeca = new ProdutoIsento(2L, "Use a Cabeça: Java", new BigDecimal("112.90"), 5, new Categoria("Livros"));
        Produto macbook = new Produto(3L, "Macbook Pro", new BigDecimal("20000.00"), 11, new Categoria("Informática"));


        System.out.println(vacina.toStringSemDescricao() + ", Categoria: " + vacina.getCategoria().getNome() + ", Valor total em estoque: R$" + vacina.calculaValorTotalEmEstoque() + ", Imposto: R$" + vacina.calculaImposto());
        System.out.println(useACabeca.toStringSemDescricao() + ", Categoria: " + useACabeca.getCategoria().getNome() + ", Valor total em estoque: R$" + useACabeca.calculaValorTotalEmEstoque() + ", Imposto: R$" + useACabeca.calculaImposto());
        System.out.println(macbook.toStringSemDescricao() + ", Categoria: " + macbook.getCategoria().getNome() + ", Valor total em estoque: R$" + macbook.calculaValorTotalEmEstoque() + ", Imposto: R$" + macbook.calculaImposto());
    }
}
