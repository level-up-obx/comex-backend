package com.onebox_comex.dtos;

import com.onebox_comex.entity.Categoria;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
public class ProdutoDTO {
    @Column(nullable = false)
    @Size(min = 2, message = "O nome da categoria deve ter pelo menos 2 caracteres")
    private String nome;

    @Column(length = 255)
    private String descricao;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precoUnitario;

    @Max(1000)
    @Column(nullable = false)
    private int quantidadeEmEstoque;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
}
