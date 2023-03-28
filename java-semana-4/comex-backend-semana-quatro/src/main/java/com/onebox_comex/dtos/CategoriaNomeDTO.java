package com.onebox_comex.dtos;
import com.onebox_comex.enums.StatusCategoriaEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Data
public class CategoriaNomeDTO {
    @NotBlank(message = "O nome da categoria é obrigatório")
    @Size(min = 2, message = "O nome da categoria deve ter pelo menos 2 caracteres")
    private String nome;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private StatusCategoriaEnum status = StatusCategoriaEnum.ATIVA;

}
