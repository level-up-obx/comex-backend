package br.com.onebox.app.repository;

import br.com.onebox.app.domain.Pedido;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class PedidoDao {
    private final EntityManager entityManager;

    public PedidoDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Pedido buscaPorId(Long id){
        return entityManager.find(Pedido.class, id);
    }
    public void cadastra(Pedido pedido){
        entityManager.persist(pedido);
    }

    public List<Pedido> listaTodos() {
        String query = "SELECT p FROM Pedido p";
        return entityManager.createQuery(query, Pedido.class).getResultList();
    }

    public List<Pedido> buscaPorData(LocalDate data){
        String query = "SELECT p FROM Pedido p WHERE p.data = :data";
        return entityManager.createQuery(query, Pedido.class)
                .setParameter("data", data)
                .getResultList();
    }
}
