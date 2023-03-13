package br.com.onebox.app.service;

import br.com.onebox.app.domain.Produto;

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
          //Aqui ficará o código para salvar no banco de dados
      } catch (Exception exception){
          System.out.println("Ocorreu o seguinte erro: " + exception.getMessage());
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
        } catch(Exception exception){
            System.out.println("Ocorreu o seguinte erro: " + exception.getMessage());
        }
        //Acima do retorno ficará a lógica de busca no banco de dados, retornei null para não estourar erro.
        return null;
    }
}
