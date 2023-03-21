package br.com.comex.dao;

import br.com.comex.entity.Produtos;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDao {
    private EntityManager em;

    public ProdutoDao(EntityManager em){
        this.em = em;
    }
    public Produtos buscaPorId(Long id){
        return null;
    }
    public void cadastra(Produtos cliente){}

    public List<Produtos> listaTodos(){
        return null;
    }
    public List<Produtos> listaIndisponiveis(){
        return null;
    }
}
