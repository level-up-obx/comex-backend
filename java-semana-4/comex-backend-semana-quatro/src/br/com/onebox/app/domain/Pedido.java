package br.com.onebox.app.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {
    private static Long idAutoIncrementado = 0L;
    private Long id;
    private Cliente cliente;
    private BigDecimal preco;
    private int quantidade;
    private LocalDate data;
}
