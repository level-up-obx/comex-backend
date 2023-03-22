package br.com.onebox.app.Dao;

import br.com.onebox.app.domain.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDao {

    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public Produto buscaPorId(Long id){
        return em.find(Produto.class, id);
    }

    public void cadastra(Produto produto){
        this.em.persist(produto);
    }

    public List<Produto> listaTodos(){
        return em.createQuery("SELECT o FROM Produto p", Produto.class)
                .getResultList();
    }

    public List<Produto> listaIndisponiveis(){
        return em.createQuery("SELECT p FROM Produto p WHERE p.quantidadeEmEstoque = 0", Produto.class)
                .getResultList();
    }
}