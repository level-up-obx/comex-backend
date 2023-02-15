import java.math.BigDecimal;

public class TestaEntradaDeProdutoNoEstoque {
    public static void main(String[] args) {

        Categoria categoria1 = new Categoria(1, "SAÚDE", Boolean.TRUE);
        Categoria categoria2 = new Categoria(2, "LIVROS", Boolean.FALSE);
        Categoria categoria3 = new Categoria(3, "INFORMÁTICA", Boolean.TRUE);

        ProdutoIsento produto1 = new ProdutoIsento(1, "Vacina", "Vacina covid", new BigDecimal("250.00"), 500, categoria1);
        ProdutoIsento produto2 = new ProdutoIsento(2, "Use a Cabeça: Java", "Livro: Use a Cabeça: Java", new BigDecimal("112.90"), 5, categoria2);
        Produto produto3 = new Produto(3, "Macbook Pro", "MacbookPro-computador", new BigDecimal("20000.00"), 15, categoria3);

        Estoque estoque = new Estoque(1000);

        estoque.registraEntrada(produto1);
        estoque.registraEntrada(produto2);
        estoque.registraEntrada(produto3);

        System.out.println("╔═══════════════════════════╗");
        System.out.println("║  Dados do Estoque         ║");
        System.out.println("╟────────────────┬─────────-─╢");
        System.out.printf("║ Capacidade     │ %8d  ║\n", estoque.getCapacidade());
        System.out.printf("║ Ocupação       │ %8d  ║\n", estoque.getOcupacao());
        System.out.printf("║ Montante total │ %8.2f ║\n", estoque.getMontante());
        System.out.println("╟────────────────┼────────-─-╢");




    }
}
