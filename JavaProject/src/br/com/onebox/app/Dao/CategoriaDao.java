package br.com.onebox.app.Dao;

import br.com.onebox.app.domain.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {

    private EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public Categoria buscaPorId(Long id){
        return em.find(Categoria.class, id);
    }

    public void cadastra(Categoria categoria){
        this.em.persist(categoria);
    }

    public List<Categoria> listaTodas(){
        return em.createQuery("SELECT c FROM Categoria c", Categoria.class)
                .getResultList();
    }
}