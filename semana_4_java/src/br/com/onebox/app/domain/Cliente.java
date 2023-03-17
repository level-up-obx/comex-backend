package br.com.onebox.app.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column( name = "primeiroNome_clientes", nullable = false)
    private String primeiroNome;

    @Column(name= "sobrenome_clientes" , nullable = false)
    private String sobrenome;

    @Column(name= "cpf_clientes" ,nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name= "telefone_clientes" ,nullable = false)
    private String telefone;

    @Column(name= "rua_clientes" ,nullable = false)
    private String rua;

    @Column(name= "numero_clientes" ,nullable = false)
    private String numero;

    @Column(name = "complemento_clientes")
    private String complemento;

    @Column(name ="bairro_clientes" , nullable = false)
    private String bairro;

    @Column(name = "cidade_clientes",nullable = false)
    private String cidade;

    @Column(name= "estado_clientes", nullable = false)
    private String estado;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;


    public Cliente(int id,
                   String primeiroNome,
                   String sobrenome,
                   String cpf,
                   String telefone,
                   String rua,
                   String numero,
                   String complemento,
                   String bairro,
                   String cidade,
                   String estado) {
        this.id = ++id;
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

    }


    public int getId() {
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

    public String mostraNomeCompleto() {
        return "NOME COMPLETO: " + primeiroNome + " " + sobrenome;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "\n" + "Id:" + id +
                "\n" + " PrimeiroNome='" + primeiroNome + '\'' +
                "\n" + " Sobrenome:'" + sobrenome + '\'' +
                "\n" + " Cpf:'" + cpf + '\'' +
                "\n" + " Telefone:'" + telefone + '\'' +
                "\n" + " Rua:'" + rua + '\'' +
                "\n" + " Numero:'" + numero + '\'' +
                "\n" + " Complemento:'" + complemento + '\'' +
                "\n" + " Bairro:'" + bairro + '\'' +
                "\n" + " Cidade:'" + cidade + '\'' +
                "\n" + " Estado:'" + estado;
    }

}
