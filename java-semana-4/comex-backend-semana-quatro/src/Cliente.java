public class Cliente {

    public static Long idAutoIncrementado = 0L;
    Long id;
    String primeiroNome;
    String sobrenome;
    String cpf;
    String telefone;
    String rua;
    String numero;
    String complemento;
    String bairro;
    String cidade;
    String estado;

    public Cliente() {
        this.id = ++idAutoIncrementado;
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
