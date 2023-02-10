public class Categoria {

    private static Long idAutoIncrementado = 0L;

    Long id;
    String nome;
    boolean status = true;

    public Categoria() {
        this.id = ++idAutoIncrementado;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  nome + " (" + id + " - " + (status ? "ATIVO" : "INATIVO") + ")";
    }
}