

public class TestaProdutoValidacaoPrecoUnitario  {

    public static void main(String[] args) throws Exception {
        try {
            Produto precounitario1 = new Produto(1, "Notebook Samsung", "Tela 14 pol", 2500.0,
                    3, "INFORMÁTICA");

            }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }

        }



    }




