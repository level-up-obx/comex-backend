package com.onebox_comex.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    @Column(nullable = false, length = 50)
    private String primeiroNome;
    @Column(nullable = false, length = 50)
    private String sobrenome;
    @Column(nullable = false, length = 11)
    private String cpf;
    @Column(nullable = false, length = 15)
    private String telefone;
    private EnderecoDTO endereco;
}
