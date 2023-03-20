package br.com.onebox.app.domain;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusCategoriaEnum status = StatusCategoriaEnum.ATIVA;

    private void tratamentoDeErroNomeCategoria(String nome) throws Exception {
            try {
                if (nome == null) {
                    throw new Exception("Nome da categoria nulo.");
                }
                if (nome.isBlank()){
                    throw new Exception("Nome da categoria vazio.");
                }
            } catch (Exception e){
                System.out.println("Ocorreu o seguinte erro: " + e.getMessage());
                throw e;
            }
        }
    public Categoria(){}
    public Categoria(String nome) throws Exception{
        tratamentoDeErroNomeCategoria(nome);
        this.nome = nome;
    }

    public Categoria(String nome, StatusCategoriaEnum status) throws Exception {
        tratamentoDeErroNomeCategoria(nome);
        this.nome = nome;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public StatusCategoriaEnum getStatus() {
        return status;
    }

    public void setNome(String nome) throws Exception {
        tratamentoDeErroNomeCategoria(nome);
        this.nome = nome;
    }

    public void setStatus(StatusCategoriaEnum status) {
        this.status = status;
    }

}