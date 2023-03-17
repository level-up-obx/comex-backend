package br.com.onebox.app.Services;

import br.com.onebox.app.domain.Categoria;


public class CategoriaService {

    public void cadastrar(Categoria novaCategoria) throws Exception {

        if (novaCategoria.equals(null)){

            throw new Exception("Não pode ser nulo");
        }


    }

    public Categoria get(Long id) throws Exception {

        try {

           if(id > 0 || id.equals(null)){
            throw new Exception("Não pode ser negativo ou nulo");
        }



        return null;
    } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
