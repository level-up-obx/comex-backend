package br.com.onebox.app.tests;

import br.com.onebox.app.domain.Categoria;

public class TestaCategoria {

    public static void main(String[] args) throws CategoriaValidacaoNomeException {


        Categoria categoria1 = new Categoria("INFORMÁTICA", true);
        System.out.println(categoria1);

        Categoria categoria2 = new Categoria("MÓVEIS", true);
        System.out.println(categoria2);

        Categoria categoria3 = new Categoria("MÓVEIS", false);
        System.out.println(categoria3);


            }


}

