package br.com.onebox.app.domain;

public class Categoria {

    private static Long idAutoIncrementado = 0L;
    private Long id;
    private String nome;
    private boolean status = true;

    private void tratamentoDeErroNomeCategoria(){
            try {
                if (nome == null) {
                    throw new RuntimeException("Nome da categoria nulo.");
                }
                if (nome.trim().isEmpty()){
                    throw new RuntimeException("Nome da categoria vazio.");
                }
            } catch (RuntimeException e){
                System.out.println("Ocorreu o seguinte erro: " + e.getMessage());
            }
        }

    public Categoria(String nome){
        this.nome = nome;
        this.id = ++idAutoIncrementado;
        tratamentoDeErroNomeCategoria();
    }

    public Categoria(String nome, boolean status){
        this.nome = nome;
        this.status = status;
        this.id = ++idAutoIncrementado;
        tratamentoDeErroNomeCategoria();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean getStatus() {
        return status;
    }

    public void setNome(String nome) {
        this.nome = nome;
        tratamentoDeErroNomeCategoria();
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  nome + " (" + id + " - " + (status ? "ATIVO" : "INATIVO") + ")";
    }
}