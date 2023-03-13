package br.com.onebox.app.domain;

public class Categoria {

    private static Long idAutoIncrementado = 0L;
    private Long id;
    private String nome;
    private boolean status = true;

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

    public Categoria(String nome) throws Exception{
        tratamentoDeErroNomeCategoria(nome);
        this.nome = nome;
        this.id = ++idAutoIncrementado;
    }

    public Categoria(String nome, boolean status) throws Exception {
        tratamentoDeErroNomeCategoria(nome);
        this.nome = nome;
        this.status = status;
        this.id = ++idAutoIncrementado;
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

    public void setNome(String nome) throws Exception {
        tratamentoDeErroNomeCategoria(nome);
        this.nome = nome;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  nome + " (" + id + " - " + (status ? "ATIVO" : "INATIVO") + ")";
    }
}