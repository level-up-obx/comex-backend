public class TestaCategoria {
    public static void main(String[] args) {
        Categoria categoria1 = new Categoria();
        Categoria categoria2 = new Categoria();
        Categoria categoria3 = new Categoria();

        categoria1.setId(1L);
        categoria1.setNome("INFORMÁTICA");

        categoria2.setId(2L);
        categoria2.setNome("MÓVEIS");
        categoria2.setStatus("INATIVA");

        categoria3.setId(3L);
        categoria3.setNome("LIVROS");

        System.out.println(categoria1.getNome() + " (" + categoria1.getId() + " - " + categoria1.getStatus() + ")");
        System.out.println(categoria2.getNome() + " (" + categoria2.getId() + " - " + categoria2.getStatus() + ")");
        System.out.println(categoria3.getNome() + " (" + categoria3.getId() + " - " + categoria3.getStatus() + ")");
    }
}
