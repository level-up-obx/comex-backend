package com.onebox_comex.service;

import com.onebox_comex.entity.Produto;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    public void cadastrar(Produto novoProduto) throws Exception {
      try{
          if(novoProduto.getCategoria() == null){
              throw new Exception("Produto não pode ser cadastrado pois a categoria indicada é nula");
          }
          if(novoProduto.getCategoria().getId() < 1){
              throw new Exception("Produto não pode ser cadastrado pois a categoria indicada é negativa");
          }
          if(novoProduto.getCategoria().getNome().isBlank()){
              throw new Exception("Produto não pode ser cadastrado pois a categoria indicada é vazia");
          }
          if(novoProduto.getNome() == null || novoProduto.getNome().isBlank()){
              throw new Exception("O nome deste produto é inválido");
          }
          //Aqui ficará o código para salvar no banco de dados
      } catch (Exception produtoException){
          System.out.println("Ocorreu o seguinte erro: " + produtoException.getMessage());
          throw produtoException;
      }

    }
    public Produto get(Long id) throws Exception {
        try{
            if(id == null){
                throw new Exception("Este id é nulo");
            }
            if(id < 1){
                throw new Exception("Este id é negativo");
            }
        } catch(Exception produtoException){
            System.out.println("Ocorreu o seguinte erro: " + produtoException.getMessage());
            throw produtoException;
        }
        //Acima do retorno ficará a lógica de busca no banco de dados, retornei null para não estourar erro.
        return null;
    }
}
