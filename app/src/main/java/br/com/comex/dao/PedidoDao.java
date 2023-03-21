package br.com.comex.dao;

import br.com.comex.entity.Pedidos;

import javax.persistence.EntityManager;
import java.util.List;

public class PedidoDao {
    private EntityManager em;

    public PedidoDao(EntityManager em){
        this.em = em;
    }
    public Pedidos buscaPorId(Long id){
        return null;
    }
    public void cadastra(Pedidos cliente){}

    public List<Pedidos> listaTodos(){
        return null;
    }
}
