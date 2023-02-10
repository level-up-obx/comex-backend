import java.math.BigDecimal;

public class TestaProduto {

    public static void main(String[] args) {
        Produto produto1 = new Produto();
        Produto produto2 = new Produto();
        Produto produto3 = new Produto();
        Categoria categoria4 = new Categoria();
        Categoria categoria5 = new Categoria();

        produto1.setNome("Notebook Samsung");
        produto1.setPrecoUnitario(new BigDecimal("3523.00"));
        produto1.setQuantidadeEmEstoque(1);

        produto2.setNome("Clean Architeture");
        produto2.setPrecoUnitario(new BigDecimal("102.90"));
        produto2.setQuantidadeEmEstoque(2);

        produto3.setNome("Monitor Dell 27");
        produto3.setPrecoUnitario(new BigDecimal("1889.00"));
        produto3.setQuantidadeEmEstoque(3);

        categoria4.setNome("INFORMÁTICA");
        categoria5.setNome("LIVROS");

        System.out.println(produto1 + "\n" + " e categoria: " + categoria4.getNome() + "." + "\n");
        System.out.println(produto2 + "\n" + " e categoria: " + categoria5.getNome() + "." + "\n");
        System.out.println(produto3 + "\n" + " e categoria: " + categoria4.getNome() + "." + "\n");

    }

}
