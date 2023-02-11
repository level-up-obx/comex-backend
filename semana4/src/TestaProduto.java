import java.math.BigDecimal;

public class TestaProduto {

	public static void main(String[] args) 
	{
		Produto produto1 = new Produto (1, "Notebook Samsung", "Informatica", new BigDecimal("3523.00"), 1,"Informatica" );
		Produto produto2 = new Produto (2, "Clean Architecture", "Livros", new BigDecimal("102.90"), 2, "Livros");
		Produto produto3 = new Produto (3, "Monitor Dell 27","Informatica", new BigDecimal("1889.00"), 3, "Informatica");

		System.out.println("-------Produto 1-------");
        System.out.println("Nome: " + produto1.getNome());
        System.out.println("Categoria: " + produto1.getCategoria());
        System.out.println("Preco unitario: " + produto1.getPrecoUnitario());
        System.out.println("Valor Total em Estoque: " + produto1.ValorTotalEstoque(produto1.getPrecoUnitario(), 
        		produto1.getQuantidadeEstoque()));
        System.out.println("Valor imposto: " + produto1.CalculaImposto(produto1.getPrecoUnitario()));
        
        System.out.println("-------Produto 2-------");
        System.out.println("Nome: " + produto2.getNome());
        System.out.println("Categoria: " + produto2.getCategoria());
        System.out.println("Preco unitario: " + produto2.getPrecoUnitario());
        System.out.println("Valor Total em Estoque: " + produto2.ValorTotalEstoque(produto2.getPrecoUnitario(), produto2.getQuantidadeEstoque()));
        System.out.println("Valor imposto: " + produto2.CalculaImposto(produto2.getPrecoUnitario()));
        
        System.out.println("-------Produto 3-------");
        System.out.println("Nome: " + produto3.getNome());
        System.out.println("Categoria: " + produto3.getCategoria());
        System.out.println("Preco unitario: " + produto3.getPrecoUnitario());
        System.out.println("Valor Total em Estoque: " + produto3.ValorTotalEstoque(produto3.getPrecoUnitario(), produto3.getQuantidadeEstoque()));
        System.out.println("Valor imposto: " + produto3.CalculaImposto(produto3.getPrecoUnitario()));
        

	}

}
