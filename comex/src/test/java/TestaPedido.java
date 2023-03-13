import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.domain.Cliente;
import br.com.onebox.app.domain.Pedido;
import br.com.onebox.app.domain.Produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TestaPedido {
    public static void main(String[] args) {

        Produto macbook = new Produto(1L, "Macbook Pro", new BigDecimal("20000.00"), 11, new Categoria("Informática"));
        Produto cleanArchitecture = new Produto(2L, "Clean Architecture", new BigDecimal("100.00"), 25, new Categoria("Livros"));
        Produto mesa4Lugares = new Produto(3L, "Mesa 4 Lugares", new BigDecimal("564.00"), 4, new Categoria("Móveis"));

        Pedido pedido1 = new Pedido(new Cliente("Marcelo"), new BigDecimal("20000.00"), 1, LocalDateTime.now());
        Pedido pedido2 = new Pedido(new Cliente("Joana"), new BigDecimal("100.00"), 6, LocalDateTime.now());
        Pedido pedido3 = new Pedido(new Cliente("Felipe"), new BigDecimal("564.00"), 9, LocalDateTime.now());

        System.out.println("Primeiro pedido -> Produto = " + macbook.getNome() + ", " + pedido1);
        System.out.println("Segundo pedido -> Produto = " + cleanArchitecture.getNome() + ", " + pedido2);
        System.out.println("Terceiro pedido -> Produto = " + mesa4Lugares.getNome() + ", " + pedido3);

    }
}
