public class TestaCategoria {

    public static void main(String[] args) {

        Categoria categoria1 = new Categoria();
        Categoria categoria2 = new Categoria();
        Categoria categoria3 = new Categoria();

        categoria1.setId(1L);
        categoria1.setNome("INFORMÁTICA");
        categoria1.setStatus("ATIVA");

        categoria2.setId(2L);
        categoria2.setNome("MÓVEIS");
        categoria2.setStatus("INATIVA");

        categoria3.setId(3L);
        categoria3.setNome("LIVROS");
        categoria3.setStatus("ATIVA");

        System.out.println(categoria1);
        System.out.println(categoria2);
        System.out.println(categoria3);

    }

}
