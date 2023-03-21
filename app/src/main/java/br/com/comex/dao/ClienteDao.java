package br.com.comex.dao;

import br.com.comex.entity.Clientes;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDao {

    private EntityManager em;

    public ClienteDao(EntityManager em){
        this.em = em;
    }
    public Clientes buscaPorId(Long id){
        return null;
    }
    public void cadastra(Clientes cliente){

    }
    public void atualiza(Clientes cliente){

    }
    public void remove(Clientes cliente){

    }
    public List<Clientes> listaTodos(){
        return null;
    }
    public List<Clientes> listaPorNome(Clientes cliente){
        return null;
    }
}
