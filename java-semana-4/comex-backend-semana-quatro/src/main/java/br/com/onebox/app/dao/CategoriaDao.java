package br.com.onebox.app.dao;

import br.com.onebox.app.domain.Categoria;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategoriaDao {
    private final EntityManager entityManager;

    private CategoriaDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Categoria buscaPorId(Long id){
        return entityManager.find(Categoria.class, id);
    }

    public void cadastra(Categoria categoria){
        entityManager.persist(categoria);
    }

    public List<Categoria> listaTodas(){
        TypedQuery<Categoria> query = entityManager.createQuery("SELECT c FROM Categoria c", Categoria.class);
        return query.getResultList();
    }
}
