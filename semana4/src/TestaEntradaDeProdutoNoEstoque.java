import java.math.BigDecimal;

public class TestaEntradaDeProdutoNoEstoque {

	public static void main(String[] args) 
	{
		Categoria categoria1 = new Categoria(0, "SAUDE", Boolean.TRUE);
        Categoria categoria2 = new Categoria(1, "LIVROS", Boolean.FALSE);
        Categoria categoria3 = new Categoria(2, "INFORMATICA", Boolean.TRUE);
        
        produtoIsento produto1 = new produtoIsento(1, "Vacina", "Vacina de gripe", new BigDecimal(250.00), 500, categoria1);
        produtoIsento produto2 = new produtoIsento(2, "Use a Cabeca: Java", "Livro de programcao", new BigDecimal(112.00), 5, categoria2);
        produtoIsento produto3 = new produtoIsento(3, "Mackbook Pro", "Notebook ultima geracao", new BigDecimal(20000.00), 15, categoria3);
        
        Estoque estoque = new Estoque(1000);
        
        estoque.registraEntrada(produto1);
        estoque.registraEntrada(produto2);
        estoque.registraEntrada(produto3);
        
        System.out.println("---- Dados do estoque - Entrada ----");
        System.out.println("Capacidade: " + estoque.getCapacidade());
        System.out.println("Ocupacao: " + estoque.getOcupacao());
        System.out.println("Montante: " + estoque.getMontante());
	}
	
	

}
