public class TestaCategoriaValidacaoNome {

    public static void main(String[] args) throws CategoriaValidacaoNomeException {
        Categoria categoria = new Categoria("Tiago",true);
        System.out.println(categoria.getNome());
    }
}
