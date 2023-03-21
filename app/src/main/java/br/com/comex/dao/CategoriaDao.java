package br.com.comex.dao;

import br.com.comex.entity.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {

    private EntityManager em;

    public CategoriaDao(EntityManager em){
        this.em = em;
    }
    public Categoria buscaPorId(Long id){
        return null;
    }
    public void cadastra(Categoria cliente){}

    public List<Categoria> listaTodos(){
        return null;
    }
}
