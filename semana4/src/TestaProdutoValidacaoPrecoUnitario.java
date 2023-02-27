import java.math.BigDecimal;

public class TestaProdutoValidacaoPrecoUnitario {

	public static void main(String[] args) {
		
		Categoria categoria1 = new Categoria(1, "SAUDE", Boolean.TRUE);
	    
		try {
		Produto produto1 = new Produto(1, "Vacina", null, new BigDecimal(250.00), 1000, categoria1);
	    System.out.println("-------Produto 1-------");
        System.out.println("Nome: " + produto1.getNome());
        System.out.println("Categoria: " + produto1.getCategoria());
        System.out.println("Preco unitario: R$ " + produto1.getPrecoUnitario());
        System.out.println("Quantidade em Estoque: " + produto1.getQuantidadeEstoque());
		}catch (PrecoInvalidoException ex) {
	    	System.out.println();
	    	System.out.println("----- Produto 1 -----");
	    	String msg = ex.getMessage();
	    	System.out.println("Mensagem: " + msg );
	    	ex.printStackTrace();
	    }
	    
		Categoria categoria3 = new Categoria(2, "INFORMATICA", Boolean.TRUE);
	    try {
	    Produto produto3 = new Produto(3, "Mackbook Pro", null, new BigDecimal(0.0), 11, categoria3);
	    System.out.println("-------Produto 3-------");
        System.out.println("Nome: " + produto3.getNome());
        System.out.println("Categoria: " + produto3.getCategoria());
        System.out.println("Preco unitario: R$ " + produto3.getPrecoUnitario());
        System.out.println("Quantidade em Estoque: " + produto3.getQuantidadeEstoque());
	    }catch (PrecoInvalidoException ex) {
	    	System.out.println();
	    	System.out.println("----- Produto 3 -----");
	    	String msg = ex.getMessage();
	    	System.out.println("Mensagem: " + msg );
	    	ex.printStackTrace();
	    	
	    }
	    
	    
        
       
        
	}

}
