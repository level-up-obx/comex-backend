package com.onebox_comex.service;

import com.onebox_comex.dtos.CategoriaNomeDTO;
import com.onebox_comex.dtos.ProdutoDTO;
import com.onebox_comex.entity.Categoria;
import com.onebox_comex.entity.Produto;
import com.onebox_comex.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    private ModelMapper modelMapper;
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
    public Produto cadastrar (ProdutoDTO produtoDTO) throws Exception {

        try{
          if(produtoDTO.getCategoria() == null){
              throw new Exception("Produto não pode ser cadastrado pois a categoria indicada é nula");
          }
          if(produtoDTO.getCategoria().getId() < 1){
              throw new Exception("Produto não pode ser cadastrado pois a categoria indicada é negativa");
          }
          if(produtoDTO.getCategoria().getNome().isBlank()){
              throw new Exception("Produto não pode ser cadastrado pois a categoria indicada é vazia");
          }
          if(produtoDTO.getNome() == null || produtoDTO.getNome().isBlank()){
              throw new Exception("O nome deste produto é inválido");
          }
          if (produtoDTO.getPrecoUnitario().compareTo(BigDecimal.ZERO) == 0){
                throw new Exception("O produto está com valor zerado.");
            }
          if(produtoDTO.getPrecoUnitario().compareTo(BigDecimal.ZERO) < 0){
                throw new Exception("O produto está com valor negativo.");
            }

          Produto produto = modelMapper.map(produtoDTO, Produto.class);
          return produtoRepository.save(produto);

      } catch (Exception produtoException){
          System.out.println("Ocorreu o seguinte erro: " + produtoException.getMessage());
          throw produtoException;
      }

    }
    public ProdutoDTO getById(Long id) throws Exception {
        try{
            if(id == null){
                throw new Exception("Este id é nulo");
            }
            if(id < 1){
                throw new Exception("Este id é negativo");
            }
            Optional<Produto> produtoOptional = produtoRepository.findById(id);
            if (produtoOptional.isPresent()) {
                Produto produto = produtoOptional.get();
                return modelMapper.map(produto, ProdutoDTO.class);
            } else {
                throw new Exception("Não foi possível encontrar a categoria com o id informado");
            }
        } catch(Exception produtoException){
            System.out.println("Ocorreu o seguinte erro: " + produtoException.getMessage());
            throw produtoException;
        }
    }
}
