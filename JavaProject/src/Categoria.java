public class Categoria {

    static int id;
     String nome;
     boolean status = true;

     public void nomevalido(String nome){
        if (this.nome != null);
        throw new CategoriaValidacaoNomeException("Não pode ser nulo");
        if (this.nome == String.valueOf(nome.isEmpty()));
        throw new CategoriaValidacaoNomeException("Nome vazio");
     }

     @Override
    public String toString() {
        return "Categoria{" +
                "id=" + ++id+
                ", nome='" + nome + '\'' +
                ", status=" + status +
                '}';
    }

    public Categoria(String nome, boolean status) {
        this.nome = nome;
        this.status = status;

    }

    public static int categoriaid(){
        id = ++id;
        return ++id;

     }

 }