import br.com.onebox.app.domain.Categoria;

public class TestaCategoria {
    public static void main(String[] args) {
        Categoria categoria1 = new Categoria(1L,"INFORMÁTICA",true);
        Categoria categoria2 = new Categoria(2L, "MÓVEIS", false);
        Categoria categoria3 = new Categoria(3L, "LIVROS", true);

        System.out.println(categoria1.getNome() + " (" + categoria1.getId() + " - " + categoria1.getStatus() + ")");
        System.out.println(categoria2.getNome() + " (" + categoria2.getId() + " - " + categoria2.getStatus() + ")");
        System.out.println(categoria3.getNome() + " (" + categoria3.getId() + " - " + categoria3.getStatus() + ")");
    }
}
