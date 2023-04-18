package br.com.onebox.app.api.cliente;

import br.com.onebox.app.domain.Cliente;
import br.com.onebox.app.domain.Endereco;

import java.util.ArrayList;
import java.util.List;

public class ClienteDto {
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;

    private Endereco endereco;

    public ClienteDto(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.nomeCompleto();
        this.cpf = cliente.getCpf();
        this.telefone = cliente.getCpf();
        this.endereco = cliente.getEndereco();
    }

    public ClienteDto(Long id, String primeiroNome, String cpf, String telefone, Endereco endereco) {
        this.id = id;
        this.nome = primeiroNome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public static Cliente converter(ClienteDto clienteDto) {
        return new Cliente(clienteDto.getId(), clienteDto.getNome(), clienteDto.getCpf(), clienteDto.getTelefone(), clienteDto.getEndereco());
    }

    public static List<ClienteDto> converter(List<Cliente> clientes) {
        List<ClienteDto> listaDto = new ArrayList<>();
        clientes.forEach(c -> {
            listaDto.add(new ClienteDto(c));
        });

        return listaDto;
    }

    public static ClienteDto converter(Cliente obj) {
        return new ClienteDto(obj.getId(), obj.getPrimeiroNome(), obj.getCpf(), obj.getTelefone(), obj.getEndereco());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
