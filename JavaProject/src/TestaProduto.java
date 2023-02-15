public class TestaProduto {

    public static void main(String[] args) {

        Produto produto1 = new Produto();
        produto1.produtoid(1);
        produto1.nome = "INFORMÁTICA";
        produto1.descricao = "Notebook Sansung";
        produto1.precoUnitario = 3523.0;
        produto1.quantidadeEstoque = 1;
        System.out.println(produto1.id + " - " + produto1.nome + " - "+ produto1.descricao +
                " - " +  produto1.precoUnitario + " - " + produto1.quantidadeEstoque + "un" +
                " - " + "Valor total: "+ produto1.getQuantidadeEstoque() +
                "\n" +" Imposto: "+produto1.getPrecoUnitario() );


        Produto produto2 = new Produto();
        produto1.produtoid(1);
        produto2.nome = "LIVROS";
        produto2.descricao = "Clean Architeure";
        produto2.precoUnitario = 102.90;
        produto2.quantidadeEstoque = 2;
        System.out.println(produto1.id + " - " + produto2.nome + " - "+ produto2.descricao +
                " - " +  produto2.precoUnitario + " - " + produto2.quantidadeEstoque+ "un"+
                " - " + "Valor total: "+ produto2.getQuantidadeEstoque()+ " Imposto: "+produto2.getPrecoUnitario()
                + "\n" +" Imposto: "+produto2.getPrecoUnitario()) ;

        Produto produto3 = new Produto();
        produto1.produtoid(1);
        produto3.nome = "INFORMÁTICA";
        produto3.descricao = "Monitor Dell 27";
        produto3.precoUnitario = 1889.00;
        produto3.quantidadeEstoque = 3;
        System.out.println(produto1.id + " - " + produto3.nome + " - "+ produto3.descricao +
                " - " +  produto3.precoUnitario + " - " + produto3.quantidadeEstoque+ "un"+
                " - "+ "Valor total: " + produto3.getQuantidadeEstoque()+ " Imposto: "+produto3.getPrecoUnitario()
                + "\n" +" Imposto: "+produto3.getPrecoUnitario());


    }

}
