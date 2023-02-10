public class Categoria {

    private static Long idAutoIncrementado = 0L;

    Long id;
    String nome;
    String status = "ATIVA";

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  nome + " (" + id + " - " + status + ")";
    }
}