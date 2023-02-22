public class Categoria {

    static int id;
     String nome;
     boolean status = true;

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