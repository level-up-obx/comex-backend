package br.com.onebox.app.Services;

import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.domain.Produto;

public class ProdutoService {

    public void cadastrar(Produto novoProduto) throws Exception {

        try {

            if (novoProduto.equals(null) ) {

                throw new Exception("Não pode ser nulo");
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Produto get(Long id) {

        try {
            if(id > 0 || id.equals(null){
                throw new Exception("Não pode ser negativo ou nulo");}
} catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


