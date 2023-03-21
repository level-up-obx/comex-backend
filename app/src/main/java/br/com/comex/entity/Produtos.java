package br.com.comex.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Produto")
public class Produtos {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private Long id;
        @NotNull
        private String nome;
        private String descricao;
        @NotNull
        private BigDecimal precoUnitario;
        @NotNull
        private Long quantidadeEstoque;
        @OneToOne(fetch = FetchType.LAZY)
        private Categoria categoria;
}
