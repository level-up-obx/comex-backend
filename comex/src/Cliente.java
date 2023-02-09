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

    //Criando construtor com todos os parâmetros
    public Cliente(Long id, String primeiroNome, String sobrenome, String cpf, String telefone, String rua, String numero, String complemento, String bairro, String cidade, String estado) {
        this.id = id;
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

    //Criando construtor vazio
    public Cliente(){

    }

    //Getters
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

    //Métodos adicionais
    public String nomeCompleto(){
        return primeiroNome + " " + sobrenome;
    }
    public String enderecoCompleto(){
        return rua + ", " + numero + ", " + complemento + " - " +bairro + " - " + cidade + " - " + estado;
    }

    //Método toString para facilitar a impressão
    @Override
    public String toString() {
        return "Cliente{" +
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
}
