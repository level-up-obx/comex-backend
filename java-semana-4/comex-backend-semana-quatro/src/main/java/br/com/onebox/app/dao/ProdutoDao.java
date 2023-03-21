package br.com.onebox.app.dao;

import br.com.onebox.app.domain.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDao {
    private final EntityManager entityManager;

    public ProdutoDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Produto buscaPorId(Long id){
        return entityManager.find(Produto.class, id);
    }

    public void cadastra(Produto produto){
        entityManager.persist(produto);
    }

    public List<Produto> listaTodos(){
        String query = "SELECT p FROM Produto p";
        return entityManager.createQuery(query, Produto.class).getResultList();
    }
    public List<Produto> listaIndisponiveis(){
        String query = "SELECT p FROM Produto p WHERE p.quantidadeEmEstoque = 0";
        return entityManager.createQuery(query, Produto.class).getResultList();
    }
}
