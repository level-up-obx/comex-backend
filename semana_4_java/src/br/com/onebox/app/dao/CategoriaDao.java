package br.com.onebox.app.dao;
import br.com.onebox.app.domain.Categoria;
import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {
    private EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public Categoria buscarPorId(Long id) {
        return em.find(Categoria.class, id);
    }

    public void cadastra(Categoria categoria) {
        this.em.persist(categoria);
    }

    public List<Categoria> listaTodas() {
        String jpql = "SELECT c FROM Categoria c";
        return em.createQuery(jpql, Categoria.class).getResultList();
    }
}
