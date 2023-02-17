public class TestaProduto {

    public static void main(String[] args) {

        Produto produto1 = new Produto();
        produto1.produtoid(1);
        produto1.setNome("INFORMÁTICA");
        produto1.setDescricao("Notebook Sansung");
        produto1.setPrecoUnitario( 3523.0);
        produto1.setQuantidadeEstoque(1);
        System.out.println(produto1.getId() + " - " + produto1.getNome() + " - "+ produto1.getDescricao() +
                " - " +  produto1.getPrecoUnitario() + " - " + produto1.getQuantidadeEstoque() + "un" +
                " - " + "Valor total: "+ produto1.getQuantidadeEstoque() +
                "\n" +" Imposto: "+produto1.getPrecoUnitario() );


        Produto produto2 = new Produto();
        produto1.produtoid(1);
        produto2.setNome("LIVROS") ;
        produto2.setDescricao("Clean Architeure");
        produto2.setPrecoUnitario(102.90);
        produto2.setQuantidadeEstoque(2);
        System.out.println(produto1.getId() + " - " + produto2.getNome() + " - "+ produto2.getDescricao() +
                " - " +  produto2.getPrecoUnitario() + " - " + produto2.getQuantidadeEstoque()+ "un"+
                " - " + "Valor total: "+ produto2.getQuantidadeEstoque()+ " Imposto: "+produto2.getPrecoUnitario()
                + "\n" +" Imposto: "+produto2.getPrecoUnitario()) ;

        Produto produto3 = new Produto();
        produto1.produtoid(1);
        produto3.setNome("INFORMÁTICA");
        produto3.setDescricao("Monitor Dell 27");
        produto3.setPrecoUnitario(1889.00);
        produto3.setQuantidadeEstoque( 3);
        System.out.println(produto1.getId() + " - " + produto3.getNome() + " - "+ produto3.getDescricao() +
                " - " +  produto3.getPrecoUnitario() + " - " + produto3.getQuantidadeEstoque()+ "un"+
                " - "+ "Valor total: " + produto3.getQuantidadeEstoque()+ " Imposto: "+produto3.getPrecoUnitario()
                + "\n" +" Imposto: "+produto3.getPrecoUnitario());


    }

}
