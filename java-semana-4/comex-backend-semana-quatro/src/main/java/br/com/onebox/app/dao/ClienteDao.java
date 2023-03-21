package br.com.onebox.app.dao;

import br.com.onebox.app.domain.Cliente;
import br.com.onebox.app.util.JpaManager;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClienteDao {
    private final EntityManager entityManager;

    public ClienteDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    public Cliente buscaPorId(Long id){
        EntityManager entityManager = JpaManager.getEntityManager();
        return entityManager.find(Cliente.class, id);
    }

    public void cadastra(Cliente cliente){
        this.entityManager.persist(cliente);
    }

    public void atualiza(Cliente cliente){
        this.entityManager.merge(cliente);
    }

    public void remove(Cliente cliente){
        cliente = entityManager.merge(cliente);
        this.entityManager.remove(cliente);
    }

    public List<Cliente> listaTodos() {
        String query = "SELECT c FROM Cliente c";
        return entityManager.createQuery(query, Cliente.class).getResultList();
    }

    public List<Cliente> listaPorNome(String nome) {
        String query = "SELECT c FROM Cliente c WHERE CONCAT(c.primeiroNome, ' ', c.sobrenome) LIKE :nome";
        return entityManager.createQuery(query, Cliente.class)
                .setParameter("nome", nome)
                .getResultList();
    }
}
