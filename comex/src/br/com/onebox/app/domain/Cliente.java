package br.com.onebox.app.domain;

public class Cliente {
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

    public Cliente(Long id, String primeiroNome, String sobrenome, String cpf, String telefone, String rua, String numero, String complemento, String bairro, String cidade, String estado) {
        this.id = GeradorDeId.proximoId();
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

    public Cliente() {
        this.id = GeradorDeId.proximoId();

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

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String nomeCompleto() {
        return primeiroNome + " " + sobrenome;
    }

    public String enderecoCompleto() {
        return rua + ", " + numero + ", " + complemento + " - " + bairro + " - " + cidade + " - " + estado;
    }

    @Override
    public String toString() {
        return "br.com.onebox.app.domain.Cliente{" +
                "id=" + id +
                ", primeiroNome='" + primeiroNome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }

    public String toStringComEnderecoConcatenado() {
        return "br.com.onebox.app.domain.Cliente " + id + ": " +
                "id = " + id +
                ", Nome Completo = '" + nomeCompleto() + '\'' +
                ", cpf = '" + cpf + '\'' +
                ", telefone = '" + telefone + '\'' +
                ", endereco = '" + enderecoCompleto() + '\'';
    }
}
