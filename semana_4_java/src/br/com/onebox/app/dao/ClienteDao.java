package br.com.onebox.app.dao;
import br.com.onebox.app.domain.Cliente;
import javax.persistence.EntityManager;
import java.util.List;


public class ClienteDao {
    private EntityManager em;

    public ClienteDao(EntityManager em) {
        this.em = em;
    }

    public void cadastra(Cliente cliente) {
        this.em.persist(cliente);
    }

    public void atualiza(Cliente cliente) {
        this.em.merge(cliente);
    }

    public void remove(Cliente cliente) {
        cliente = em.merge(cliente);
        this.em.remove(cliente);
    }

    public Cliente buscaPorId(Long id) {
        return em.find(Cliente.class, id);
    }

    public List<Cliente> listaTodos() {
        String jpql = "SELECT c FROM Cliente c";
        return em.createQuery(jpql, Cliente.class).getResultList();
    }

    public List<Cliente> listaPorNome(String nome) {
        String jpql = "SELECT c FROM Cliente c WHERE c.nome = :nome";
        return em.createQuery(jpql, Cliente.class)
                .setParameter("nome", nome)
                .getResultList();
    }
}
