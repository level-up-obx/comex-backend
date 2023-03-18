package br.com.onebox.app.Entidades;

import javax.persistence.Entity;

@Entity

public class CategoriaEntity {

    private String nome;
    private Boolean status = true;

    public Boolean getStatus() {

        if (status == true) {
            System.out.println("ATIVA");
        } else {
            System.out.println("INATIVA");
        }
        return null;
    }
}







