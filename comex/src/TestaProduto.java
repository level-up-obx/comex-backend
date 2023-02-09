public class TestaProduto {
    //Criando método para quebra de linha
    public static void quebraLinha(){
        System.out.println("-".repeat(90));
    }
    public static void main(String[] args) {
        //Instanciando os objetos
        Produto produto1 = new Produto();
        Produto produto2 = new Produto();
        Produto produto3 = new Produto();
        Categoria informatica = new Categoria();
        informatica.setNome("INFORMÁTICA");
        Categoria livros = new Categoria();
        livros.setNome("LIVROS");

        //Setando os valores do produto 1
        produto1.setId(1L);
        produto1.setNome("Notebook Samsung");
        produto1.setPrecoUnitario(3523.00);
        produto1.setQuantidadeEmEstoque(1);
        produto1.setCategoria(informatica);

        //Setando os valores do produto 2
        produto2.setId(2L);
        produto2.setNome("Clean Architecture");
        produto2.setPrecoUnitario(102.90);
        produto2.setQuantidadeEmEstoque(2);
        produto2.setCategoria(livros);

        //Setando os valores do produto 3
        produto3.setId(3L);
        produto3.setNome("Monitor Dell 27");
        produto3.setPrecoUnitario(1889.00);
        produto3.setQuantidadeEmEstoque(3);
        produto3.setCategoria(informatica);

        //Imprimindo resultados
        System.out.println("Informações do produto 1:\n" + produto1.toStringSemDescricao() + "\nCategoria: " + produto1.getCategoria().getNome() + "\n" + produto1.calculaValorTotalEmEstoque() + "\n" + produto1.calculaImposto());
        quebraLinha();
        System.out.println("Informações do produto 2:\n" + produto2.toStringSemDescricao() + "\nCategoria: " + produto2.getCategoria().getNome() + "\n" + produto2.calculaValorTotalEmEstoque() + "\n" + produto2.calculaImposto());
        quebraLinha();
        System.out.println("Informações do produto 3:\n" + produto3.toStringSemDescricao() + "\nCategoria: " + produto3.getCategoria().getNome() + "\n" + produto3.calculaValorTotalEmEstoque() + "\n" + produto3.calculaImposto());
        quebraLinha();
    }
}
