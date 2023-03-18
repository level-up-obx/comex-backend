package br.com.onebox.app.Entidades;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class ProdutoEntity {

    private String Nome;
    private BigDecimal Preco;
    private String Descricao;
    private Integer Quantidade_em_estoque;
    private String Categoria;

}
