import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.domain.Produto;

import java.math.BigDecimal;

public class TestaProdutoValidacaoPrecoUnitario {
    public static void main(String[] args) {
        Produto vacina = new Produto(1L, "Vacina", new BigDecimal("250.00"), 1000, new Categoria("Saúde"));
        System.out.println(vacina + " br.com.onebox.app.domain.Categoria = " + vacina.getCategoria().getNome() + ", Valor total em estoque = " + vacina.calculaValorTotalEmEstoque() + ", Valor total do imposto = " + vacina.calculaImposto());

        Produto macbook = new Produto(3L, "Macbook Pro", new BigDecimal("0.0"), 11, new Categoria("Informática"));
        System.out.println(macbook + " br.com.onebox.app.domain.Categoria = " + macbook.getCategoria().getNome() + ", Valor total em estoque = " + macbook.calculaValorTotalEmEstoque() + ", Valor total do imposto = " + macbook.calculaImposto());

    }
}
