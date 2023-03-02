package br.com.onebox.app.domain;

public class Cliente {

    static int id ;
    String primeiroNome;
    String segundoNome;

    String cpf;
    String telefone;
    String rua;
    String numeroCasa;
    String complemento;
    String bairro;
    String cidade;
    String estado;

    public int getId() {
        return id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getSegundoNome() {
        return segundoNome;
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

    public String getNumeroCasa() {
        return numeroCasa;
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

    public int getclienteid() {
        this.id = ++id;
        return id;
    }

    public String getnomeCompleto() {
        String nomeCompleto = primeiroNome + segundoNome;
        return nomeCompleto;


    }
    public String getenderecoCompleto(){
        String enderecoCompleto = rua + numeroCasa + complemento + bairro + cidade + estado;
        return enderecoCompleto;

    }

    @Override
    public String toString() {
        return "br.com.onebox.app.domain.Cliente{" + ",id='"
                 + getclienteid() +
                ", nomeCompleto='" + getnomeCompleto() + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", Endereço ='" + getenderecoCompleto() +
                '}';
    }

    public Cliente(String primeiroNome, String segundoNome, String cpf, String telefone, String rua, String numeroCasa, String complemento, String bairro, String cidade, String estado) {

        this.primeiroNome = primeiroNome;
        this.segundoNome = segundoNome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;


    }
}






