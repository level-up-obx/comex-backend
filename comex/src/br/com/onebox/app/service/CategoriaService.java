package br.com.onebox.app.service;

import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.exceptions.CategoriaInvalidaException;

import java.util.ArrayList;
import java.util.List;

public class CategoriaService {
    List<Categoria> categorias = new ArrayList<Categoria>();

    public void cadastrar(Categoria novaCategoria) throws CategoriaInvalidaException {
        if(novaCategoria.equals(null)){
            throw new CategoriaInvalidaException("Categoria Inválida, valores nulos encontrados!");
        }
        categorias.add(novaCategoria);
        System.out.println("Categoria cadastrada com sucesso");
    }
    public Categoria get(Long id) throws CategoriaInvalidaException {
        if(id.equals(null) || id < 0){
            throw new CategoriaInvalidaException("Categoria invalida, id nulo ou menor que zero");
        }
        return categorias.stream()
                .filter(c -> c.getId().equals(id))
                .findAny().get();
    }
}
