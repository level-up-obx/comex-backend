
public class TestaSaidaDeProdutoNoEstoque {

    public static void main(String[] args) {

        Categoria categoria1 = new Categoria("SAÚDE", true);
        Categoria categoria2 = new Categoria("LIVROS", false);
        Categoria categoria3 = new Categoria("INFORMÁTICA", true);

        Estoque estoque2 = new Estoque();

        ProdutoIsento produto1 = new ProdutoIsento(1,"Vacina", "Primeira dose", 250.00, 500, "Saude");
        System.out.println(produto1);


        ProdutoIsento produto2 = new ProdutoIsento(2,"Use a cabeça", "E a pedra filosofal", 112.9, 5, "Livros");
        System.out.println(produto2);

        ProdutoIsento produto3 = new ProdutoIsento(3," Macbook Pro", "15 pol", 20000.0, 15, "Informática");
        System.out.println(produto3);

        estoque2.registrSaida(produto1);
        estoque2.registrSaida(produto2);
        estoque2.registrSaida(produto3);

        System.out.println(estoque2);






    }
}

