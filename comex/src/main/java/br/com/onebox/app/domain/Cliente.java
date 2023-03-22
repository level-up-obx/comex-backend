package br.com.onebox.app.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "primeiro_nome", length = 20, nullable = false)
    private String primeiroNome;

    @Column(length = 50, nullable = false)
    private String sobrenome;

    @Column(length = 16, nullable = false)
    private String cpf;

    @Column(length = 15, nullable = false)
    private String telefone;

    @Embedded
    private Endereco endereco;

    public Cliente(Long id, String primeiroNome, String sobrenome, String cpf, String telefone, Endereco endereco) {
        this.id = GeradorDeId.proximoId();
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Cliente() {
        this.id = GeradorDeId.proximoId();

    }

    public Cliente(String nome){
        this.primeiroNome = nome;
    }
    public Long getId() {
        return id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco(){
        return endereco;
    }

    public String nomeCompleto() {
        return primeiroNome + " " + sobrenome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", primeiroNome='" + primeiroNome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' + endereco +
                '}';
    }
}
