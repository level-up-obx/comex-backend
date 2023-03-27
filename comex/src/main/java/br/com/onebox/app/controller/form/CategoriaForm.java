package br.com.onebox.app.controller.form;

import br.com.onebox.app.domain.Categoria;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CategoriaForm {

    @NotNull @NotEmpty @Size(min = 2)
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria converter(){
        return new Categoria(nome);
    }
}
