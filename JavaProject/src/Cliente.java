public class Cliente {

    int id;
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

    public void produtoid(int meuid) {
        this.id = this.id + meuid++;
    }

    public String nomeCompleto(String nomeCompleto) {
        nomeCompleto = primeiroNome + segundoNome;
        return nomeCompleto;


    }
    public String enderecoCompleto(String enderecoCompleto){
        enderecoCompleto = rua + numeroCasa + complemento + bairro + cidade + estado;
        return enderecoCompleto;

    }
}






