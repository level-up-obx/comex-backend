package br.com.onebox.app.tests;
import br.com.onebox.app.domain.Cliente;
import br.com.onebox.app.domain.Pedido;
import br.com.onebox.app.domain.Produto;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TestaPedido {
    public static void main(String[] args) throws Exception {
        Produto produto = new Produto("Notebook Samsung", new BigDecimal("3523.00"));

        Produto produto2 = new Produto("Clean Architeture", new BigDecimal("102.90"));

        Produto produto3 = new Produto("Monitor Dell 27", new BigDecimal("1889.00"));

        Cliente cliente = new Cliente("João", "Orlando");

        Cliente cliente2 = new Cliente("Ricardo", "Ferreira");

        Cliente cliente3 = new Cliente("Fernando", "Junior");

        Pedido pedido = new Pedido(cliente, produto.getPrecoUnitario(),1, LocalDate.of(2023, 03, 06));

        Pedido pedido2 = new Pedido(cliente2, produto2.getPrecoUnitario(),2, LocalDate.of(2023, 03, 06));

        Pedido pedido3 = new Pedido(cliente3, produto3.getPrecoUnitario(),3, LocalDate.of(2023, 03, 06));

        System.out.println("Produto: " + produto.getNome() + pedido);
        System.out.println("Produto: " + produto2.getNome() + pedido2);
        System.out.println("Produto: " + produto3.getNome() + pedido3);

    }
}
