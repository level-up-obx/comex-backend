package br.com.onebox.app.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

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


    public Endereco(
        String rua,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado){
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;

    }

    public Endereco() {

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

}
