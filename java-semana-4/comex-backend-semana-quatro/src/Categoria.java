public class Categoria {

    private static Long idAutoIncrementado = 0L;
    private Long id;
    private String nome;
    private boolean status = true;

    private void tratamentoDeErroNomeCategoria(){
        if (nome == null || nome.trim().isEmpty()){
            try {
                throw new Exception("Nome da categoria inválido, tente novamente.");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
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

    @Override
    public String toString() {
        return  nome + " (" + id + " - " + (status ? "ATIVO" : "INATIVO") + ")";
    }
}