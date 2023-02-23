public class TestaCategoriaValidacaoNome {
    public static void main(String[] args) {
        Categoria categoria1 = new Categoria("INFORMÁTICA");
        System.out.println(categoria1.getNome());

        String vazia = "";
        Categoria categoria2 = new Categoria();
        categoria2.setNome(vazia);
        System.out.println(categoria2.getNome());

        Categoria categoria3 = new Categoria(1L, null, true);
        System.out.println(categoria3);
    }
}
