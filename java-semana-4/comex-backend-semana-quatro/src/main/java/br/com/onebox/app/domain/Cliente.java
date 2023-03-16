package br.com.onebox.app.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String primeiroNome;
    @Column(nullable = false, length = 50)
    private String sobrenome;
    @Column(nullable = false, length = 15)
    private String cpf;
    @Column(nullable = false, length = 15)
    private String telefone;
    @Column(nullable = false, length = 100)
    private String rua;
    @Column(nullable = false, length = 10)
    private String numero;
    @Column(length = 100)
    private String complemento;
    @Column(nullable = false, length = 255)
    private String bairro;
    @Column(nullable = false, length = 50)
    private String cidade;
    @Column(nullable = false, length = 2)
    private String estado;

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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente(String primeiroNome, String sobrenome, String cpf, String telefone, String rua, String numero, String complemento, String bairro, String cidade, String estado) {
        this();
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

    public String nomeCompleto(){
       return primeiroNome + " " + sobrenome;
    }

    public String enderecoCompleto(){
        return rua + " " + numero + " " + bairro + " " + complemento + " " + cidade + " " + estado;
    }

    @Override
    public String toString() {
        return  "Nome completo: " + nomeCompleto() + ", CPF: " + cpf + ", telefone: " + telefone +
                " e endereço completo: " + enderecoCompleto() + id;
    }
}
