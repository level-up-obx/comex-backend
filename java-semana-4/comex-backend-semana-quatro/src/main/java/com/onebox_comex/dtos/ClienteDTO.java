package com.onebox_comex.dtos;
import com.onebox_comex.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private Long id;
    private String primeiroNome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

    public ClienteDTO(Cliente cliente){
        this.id = cliente.getId();
        this.primeiroNome = cliente.getPrimeiroNome();
        this.sobrenome = cliente.getSobrenome();
        this.cpf = cliente.getCpf();
        this.telefone = cliente.getCpf();
        this.rua = cliente.getRua();
        this.numero = cliente.getNumero();
        this.complemento = cliente.getComplemento();
        this.bairro = cliente.getBairro();
        this.cidade = cliente.getCidade();
        this.estado = cliente.getEstado();

    }

    public ClienteDTO(String primeiroNome, String sobrenome, String cpf, String telefone, String rua, String numero, String complemento, String bairro, String cidade, String estado) {
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }
}
