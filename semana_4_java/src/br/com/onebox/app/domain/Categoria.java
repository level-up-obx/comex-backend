package br.com.onebox.app.domain;
import br.com.onebox.app.exceptions.CategoriaInvalidaException;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( name = "nome_categorias", nullable = false)
    @Size(min = 2, message = "O nome deve possuir pelo menos 2 caracteres.")
    private String nome;
    @Column(name = "status_categorias",nullable = false)
    private Boolean status;

    public Categoria(Long id, String nome, Boolean status) throws CategoriaInvalidaException {
        this.id = ++id;
        setNome(nome);
        this.status = status;
    }

    public Categoria() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws CategoriaInvalidaException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new CategoriaInvalidaException("O nome da categoria não pode ser vazio ou nulo.");
        }
        this.nome = nome;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean  status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return nome + " (" + id + " - " + (status ? "ATIVO" : "INATIVO") + ")";
    }
}