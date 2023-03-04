package br.com.onebox.app.tests;

import br.com.onebox.app.domain.Produto;

public class TestaProdutoValidacaoPrecoUnitario  {

    public static void main(String[] args) throws Exception {
        try {
            Produto precounitario1 = new Produto(1, "Notebook Samsung", "Tela 14 pol", 0,
                    3, "INFORMÁTICA");

            }catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }

        }



    }




