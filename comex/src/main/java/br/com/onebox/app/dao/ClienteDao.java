package br.com.onebox.app.dao;

import br.com.onebox.app.domain.Cliente;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClienteDao {

    private EntityManager em;

    public ClienteDao(EntityManager em) {
        this.em = em;
    }

    public Cliente buscaPorId(Long id){
        return em.find(Cliente.class, id);
    }

    public void cadastra(Cliente cliente){
        this.em.persist(cliente);
    }

    public void atualiza(Cliente cliente){
        this.em.merge(cliente);
    }

    public void remove(Cliente cliente){
        cliente = em.merge(cliente);
        this.em.remove(cliente);
    }

    public List<Cliente> listaTodos(){
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class)
                .getResultList();
    }

    public List<Cliente> listaPorNome(String nome){
        return em.createQuery("SELECT c FROM Cliente c WHERE c.nome = :nome", Cliente.class)
                .setParameter("nome", nome)
                .getResultList();
    }
}
