package com.onebox_comex.dtos;

import com.onebox_comex.entity.Categoria;
import com.onebox_comex.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {
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

    private Long categoriaId;

//    public ProdutoDTO(Long id, String nome, BigDecimal precoUnitario) {
//    }

//    public Produto toEntity() {
//        return new Produto(nome, precoUnitario, descricao, quantidadeEmEstoque, categoria);
//    }

}
