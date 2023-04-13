package br.com.onebox.app.dao;

import br.com.onebox.app.domain.Pedido;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

public class PedidoDao {

    private EntityManager em;

    public PedidoDao(EntityManager em) {
        this.em = em;
    }

    public Pedido buscaPorId(Long id){
        return em.find(Pedido.class, id);
    }

    public void cadastra(Pedido pedido){
        this.em.persist(pedido);
    }

    public List<Pedido> listaTodos(){
        return em.createQuery("SELECT p FROM Pedido p", Pedido.class)
                .getResultList();
    }
    public List<Pedido> buscaPorData(LocalDate data){
        return em.createQuery("SELECT p FROM Pedido p WHERE p.data = :data", Pedido.class)
                .setParameter("data", data)
                .getResultList();
    }
}
