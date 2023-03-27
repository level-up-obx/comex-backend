package br.com.onebox.app.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
    @Column(nullable = false, length = 100)
    private String rua;
    @Column(nullable = false, length = 10)
    private String numero;
    @Column(length = 100)
    private String complemento;
    @Column(nullable = false, length = 100)
    private String bairro;
    @Column(nullable = false, length = 50)
    private String cidade;
    @Column(nullable = false, length = 2)
    private String estado;

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
