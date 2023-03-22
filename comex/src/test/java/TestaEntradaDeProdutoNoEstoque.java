import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.domain.Estoque;
import br.com.onebox.app.domain.Produto;
import br.com.onebox.app.domain.ProdutoIsento;

import java.math.BigDecimal;

public class TestaEntradaDeProdutoNoEstoque {
    public static void main(String[] args) {
        ProdutoIsento vacina = new ProdutoIsento(1L, "Vacina", new BigDecimal("250.00"), 500, new Categoria("Saúde"));
        ProdutoIsento useACabeca = new ProdutoIsento(2L, "Use a Cabeça: Java", new BigDecimal("112.90"), 5, new Categoria("Livros"));
        Produto macbook = new Produto(3L, "Macbook Pro", new BigDecimal("20000.00"), 15, new Categoria("Informática"));

        Estoque estoque = new Estoque();
        estoque.registraEntrada(vacina);
        estoque.registraEntrada(useACabeca);
        estoque.registraEntrada(macbook);

        System.out.println(estoque);
    }

}
