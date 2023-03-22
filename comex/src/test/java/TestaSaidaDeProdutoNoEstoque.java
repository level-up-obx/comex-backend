import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.domain.Estoque;
import br.com.onebox.app.domain.ProdutoIsento;

import java.math.BigDecimal;

public class TestaSaidaDeProdutoNoEstoque {
    public static void main(String[] args) {
        ProdutoIsento vacina = new ProdutoIsento(1L, "Vacina", new BigDecimal("250.00"), 500, new Categoria("Saúde"));

        Estoque estoque = new Estoque();
        estoque.registraEntrada(vacina);
        System.out.println(estoque);
        estoque.registraSaida(vacina);
        System.out.println(estoque);

    }
}
