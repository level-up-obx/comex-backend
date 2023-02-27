import java.math.BigDecimal;

public class TestaProdutoValidacaoPrecoUnitario {
    public static void main(String[] args) {
        Categoria categoria1 = new Categoria(0, "SAÚDE", Boolean.TRUE);
        Categoria categoria2 = new Categoria(1, "INFORMARICA", Boolean.TRUE);

        try {
            Produto vacina = new Produto(1, "Vacina", "Vacina contra COVID-19",
                    new BigDecimal("250.00"), 1000, categoria1);

            System.out.printf("Produto: %s" +
                            "\nDescrição: %s" +
                            "\nCategoria: %s" +
                            "\nPreço unitário: R$ %s" +
                            "\nQuantidade em estoque: %d" +
                            "\nValor total em estoque: R$ %s" +
                            "\nImposto: R$ %s\n\n",
                    vacina.getNome(), vacina.getDescricao(), vacina.getCategoria().getNome(), vacina.getPrecoUnitario(), vacina.getQuantidadeEstoque(), vacina.calculaValorTotalEstoque(), vacina.calculaImposto(vacina.getPrecoUnitario()));
        } catch (PrecoInvalidoException msg){
            System.out.println(msg.getMessage());
        }

        try {
            Produto macbookPro = new Produto(3, "Macbook Pro", "Notebook Apple",
                    BigDecimal.ZERO,11, categoria2);

            System.out.printf("Produto: %s" +
                            "\nDescrição: %s" +
                            "\nCategoria: %s" +
                            "\nPreço unitário: R$ %s" +
                            "\nQuantidade em estoque: %d" +
                            "\nValor total em estoque: R$ %s" +
                            "\nImposto: R$ %s\n\n",
                    macbookPro.getNome(), macbookPro.getDescricao(), macbookPro.getCategoria().getNome(), macbookPro.getPrecoUnitario(), macbookPro.getQuantidadeEstoque(),
                    macbookPro.calculaValorTotalEstoque(), macbookPro.calculaImposto(macbookPro.getPrecoUnitario()));
        } catch (PrecoInvalidoException msg){
            System.out.println(msg.getMessage());
        }
    }

}
