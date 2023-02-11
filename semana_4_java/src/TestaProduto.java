import java.math.BigDecimal;

    public class TestaProduto {
        public static void main(String[] args) {
            Produto produto1 = new Produto(1, "Notebook Samsung", "Informática", new BigDecimal("3523.00"), 1, "Informática");
            Produto produto2 = new Produto(2, "Clean Architecture", "Livros", new BigDecimal("102.90"), 2, "Livros");
            Produto produto3 = new Produto(3, "Monitor Dell 27", "Informática", new BigDecimal("1889.00"), 3, "Informática");

            System.out.println("--------- PRODUTO - 1 NOTEBOOK SAMSUNG ----------");
            System.out.println("Nome: " + produto1.getNome());
            System.out.println("Categoria: " + produto1.getCategoria());
            System.out.println("Preço Unitário: " + produto1.getPrecoUnitario());
            System.out.println("Quantidade em Estoque: " + produto1.getQuantidadeEstoque());
            System.out.println("Valor Total em Estoque: " + produto1.calculaValorTotalEstoque(produto1.getPrecoUnitario(), produto1.getQuantidadeEstoque()));
            System.out.println("Imposto: " + produto1.calculaImposto(produto1.getPrecoUnitario()));


            System.out.println("--------- Produto - 2 CLEAN ARCHITECTURE ----------");
            System.out.println("Nome: " + produto2.getNome());
            System.out.println("Categoria: " + produto2.getCategoria());
            System.out.println("Preço Unitário: " + produto2.getPrecoUnitario());
            System.out.println("Quantidade em Estoque: " + produto2.getQuantidadeEstoque());
            System.out.println("Valor Total em Estoque: " + produto2.calculaValorTotalEstoque(produto2.getPrecoUnitario(), produto2.getQuantidadeEstoque()));
            System.out.println("Imposto: " + produto2.calculaImposto(produto2.getPrecoUnitario()));


            System.out.println("--------- Produto - 3 MONITOR DELL ----------");
            System.out.println("Nome: " + produto3.getNome());
            System.out.println("Categoria: " + produto3.getCategoria());
            System.out.println("Preço Unitário: " + produto3.getPrecoUnitario());
            System.out.println("Quantidade em Estoque: " + produto3.getQuantidadeEstoque());
            System.out.println("Valor Total em Estoque: " + produto3.calculaValorTotalEstoque(produto3.getPrecoUnitario(), produto1.getQuantidadeEstoque()));
        }
    }

