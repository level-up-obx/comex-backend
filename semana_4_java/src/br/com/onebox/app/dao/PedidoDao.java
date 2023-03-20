package br.com.onebox.app.dao;

import br.com.onebox.app.domain.Pedido;
import javax.persistence.EntityManager;
import java.util.List;

public class PedidoDao {
    private EntityManager em;

    public PedidoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastra(Pedido pedido) {
        this.em.persist(pedido);
    }

    public Pedido buscaPorId(Long id) {
        return em.find(Pedido.class, id);
    }

    public List<Pedido> listaTodos() {
        String jpql = "SELECT p FROM Pedido p";
        return em.createQuery(jpql, Pedido.class).getResultList();
    }
}