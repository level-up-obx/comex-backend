public class Categoria {
    private Long id;
    private String nome;
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
        this.nome = nome;
    }

    public String getStatus() {
        if (status){
            return "ATIVA";
        } else {
            return "INATIVA";
        }
    }

    public void setStatus(Boolean status) {

        this.status = status;
    }

    public Categoria(Long id, String nome, Boolean status) {
        this.id = GeradorDeId.proximoId();
        this.nome = nome;
        this.status = status;
    }
    public Categoria(){
        this.id = GeradorDeId.proximoId();

    }
    public Categoria(String nome){
        this.nome = nome;
    }
}
