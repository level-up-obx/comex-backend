public class TestaCategoria {
        public static void main(String[] args) {
            Categoria categoria1 = new Categoria(1, "INFORMÁTICA", Boolean.TRUE);
            Categoria categoria2 = new Categoria(2, "MÓVEIS", Boolean.FALSE);
            Categoria categoria3 = new Categoria(3, "LIVROS", Boolean.TRUE);

            exibirInformacoesCategoria(categoria1);
            exibirInformacoesCategoria(categoria2);
            exibirInformacoesCategoria(categoria3);
        }

        private static void exibirInformacoesCategoria(Categoria categoria) {
            System.out.println(categoria.getNome() + " (" + categoria.getId() + " - " +
                    (categoria.getStatus() ? "ATIVA" : "INATIVA") + ")");
        }
    }
