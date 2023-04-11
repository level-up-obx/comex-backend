package com.onebox_comex.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.onebox_comex.dtos.ProdutoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Size(min = 2, message = "O nome da categoria deve ter pelo menos 2 caracteres")
    private String nome;
    @Column(length = 255)
    private String descricao;
    @Column(nullable = false, precision = 10, scale = 2)
    @Positive
    private BigDecimal precoUnitario;
    @Max(1000)
    @Column(nullable = false)
    private int quantidadeEmEstoque;
    @ManyToOne
    private Categoria categoria;

    public Produto(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", precoUnitario=" + precoUnitario +
                ", quantidadeEmEstoque=" + quantidadeEmEstoque +
                '}';
    }

    public ProdutoDTO converter(){
        return new ProdutoDTO(this);
    }
}
