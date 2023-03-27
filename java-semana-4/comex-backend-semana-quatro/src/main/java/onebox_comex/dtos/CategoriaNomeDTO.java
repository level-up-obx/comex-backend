package onebox_comex.dtos;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Data
public class CategoriaNomeDTO {
    @NotBlank(message = "O nome da categoria é obrigatório")
    @Size(min = 2, message = "O nome da categoria deve ter pelo menos 2 caracteres")
    private String nome;
}
