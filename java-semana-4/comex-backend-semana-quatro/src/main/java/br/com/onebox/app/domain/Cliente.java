package br.com.onebox.app.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String primeiroNome;
    @Column(nullable = false, length = 50)
    private String sobrenome;
    @Column(nullable = false, length = 11)
    private String cpf;
    @Column(nullable = false, length = 15)
    private String telefone;
    @OneToMany(mappedBy = "cliente")
    @JoinColumn(name = "pedido_id", nullable = false)
    private List<Pedido> pedido;
    @Embedded
    private Endereco endereco;

    public Cliente(String primeiroNome, String sobrenome) {
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }



    public Cliente(String primeiroNome, String sobrenome, String cpf, String telefone) {
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.telefone = telefone;

    }

    public String nomeCompleto(){
       return primeiroNome + " " + sobrenome;
    }

}
