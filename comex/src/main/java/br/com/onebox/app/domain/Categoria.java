package br.com.onebox.app.domain;

import br.com.onebox.app.exception.NomeInvalidoException;
import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Boolean status = Boolean.TRUE;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().equals("")) {
            throw new NomeInvalidoException("O nome não pode ser vazio ou nulo");
        }
        this.nome = nome;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {

        this.status = status;
    }

    public Categoria(Long id, String nome, Boolean status) {
        this.id = id;
        if (nome == null || nome.trim().equals("")) {
            throw new NomeInvalidoException("O nome não pode ser vazio ou nulo");
        }
        this.nome = nome;
        this.status = status;
    }

    public Categoria() {
        this.status = Boolean.TRUE;
    }

    public Categoria(String nome) {
        if (nome == null || nome.trim().equals("")) {
            throw new NomeInvalidoException("O nome não pode ser vazio ou nulo");
        }
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", status=" + status +
                '}';
    }
}
