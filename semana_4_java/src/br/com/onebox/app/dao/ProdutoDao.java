package br.com.onebox.app.dao;


import br.com.onebox.app.domain.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDao {
    private EntityManager em;

    public ProdutoDao(EntityManager em){
        this.em =em;
    }
    public void cadastra(Produto produto) {
        this.em.persist(produto);
    }

    public void atualiza(Produto produto) {
        this.em.merge(produto);
    }

    public void remove(Produto produto) {
        produto = em.merge(produto);
        this.em.remove(produto);
    }

    public Produto buscaPorId(Long id) {
        return em.find(Produto.class, id);
    }

    public List<Produto> listaTodos() {
        String jpql = "SELECT p FROM Produto p";
        return em.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> listaIndisponiveis() {
        String jpql = "SELECT p FROM Produto p WHERE p.quantidadeEstoque = 0";
        return em.createQuery(jpql, Produto.class).getResultList();
    }
}
