package br.com.onebox.app.domain;
import br.com.onebox.app.exceptions.CategoriaInvalidaException;
import org.intellij.lang.annotations.Identifier;

import javax.persistence.*;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nome;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.ATIVA;

    public Categoria(int id, String nome, Status status) throws CategoriaInvalidaException {
        setNome(nome);
        setStatus(status);
    }

    public Categoria() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status {
        ATIVA, INATIVA
    }
}