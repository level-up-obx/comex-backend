public class TestaCategoria {

    public static void main(String[] args) {

        Categoria categoria1 = new Categoria();
        Categoria categoria2 = new Categoria();
        Categoria categoria3 = new Categoria();

        categoria1.setNome("INFORMÁTICA");

        categoria2.setNome("MÓVEIS");
        categoria2.setStatus("INATIVA");

        categoria3.setNome("LIVROS");

        System.out.println(categoria1);
        System.out.println(categoria2);
        System.out.println(categoria3);

    }

}
