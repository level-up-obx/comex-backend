package br.com.onebox.app.service;

import br.com.onebox.app.domain.Categoria;

public class CategoriaService {
    public void cadastrar (Categoria novaCategoria) throws Exception {
        try{
            if (novaCategoria == null){
                throw new Exception("Esta categoria é nula");
            }
            if (novaCategoria.getNome() == null){
                throw new Exception("O nome desta categoria é nulo");
            }
            if (novaCategoria.getNome().isBlank()){
                throw new Exception("O nome da categoria está vazio");
            }
            //Aqui ficará o código para salvar no banco de dados
        } catch (Exception exception){
            System.out.println("O erro ocorrido foi: " + exception.getMessage());
            throw exception;
        }
    }

    public Categoria get(Long id) throws Exception{
        try {
            if(id == null || id < 1){
                throw new Exception("O id não é válido, está nulo ou negativo");
            }
//            Aqui eu buscarei a categoria no banco de dados
            return null;
        } catch (Exception exception){
            System.out.println("O erro ocorrido foi: " + exception.getMessage());
            throw exception;
        }
    }
}
