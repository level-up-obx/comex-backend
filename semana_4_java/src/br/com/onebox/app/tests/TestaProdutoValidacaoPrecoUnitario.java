package br.com.onebox.app.tests;

import br.com.onebox.app.PrecoInvalidoException;
import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.domain.Produto;

import java.math.BigDecimal;

public class TestaProdutoValidacaoPrecoUnitario {
    public static void main(String[] args) {
        Categoria categoria1 = new Categoria(0, "SAÚDE", Boolean.TRUE);
        Categoria categoria2 = new Categoria(1, "INFORMARICA", Boolean.TRUE);

        try {
            Produto vacina = new Produto(1, "Vacina", "Vacina contra COVID-19",
                    new BigDecimal("250.00"), 1000, categoria1);
            System.out.println(vacina);
            System.out.println();

            Produto macbookPro = new Produto(3, "Macbook Pro", "Notebook Apple",
                    BigDecimal.ZERO, 11, categoria2);
            System.out.println(macbookPro);
        } catch (PrecoInvalidoException msg) {
            System.out.println(msg.getMessage());
        }
    }
}