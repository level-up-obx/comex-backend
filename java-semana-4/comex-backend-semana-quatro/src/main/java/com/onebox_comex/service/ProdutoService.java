package com.onebox_comex.service;
import com.onebox_comex.dtos.ProdutoDTO;
import com.onebox_comex.entity.Categoria;
import com.onebox_comex.entity.Produto;
import com.onebox_comex.repository.CategoriaRepository;
import com.onebox_comex.repository.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public Produto cadastrar(ProdutoDTO produtoDTO) throws Exception {
        Produto produto = new Produto();
        produto.setNome(produtoDTO.getNome());
        produto.setPrecoUnitario(produtoDTO.getPrecoUnitario());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setQuantidadeEmEstoque(produtoDTO.getQuantidadeEmEstoque());

        Categoria categoria = categoriaRepository.findById(produtoDTO.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        produto.setCategoria(categoria);

        Optional<Produto> produtoOptional = produtoRepository.findByNome(produtoDTO.getNome());

        try{
            if (produtoOptional.isPresent()) {
                throw new Exception("Já existe um produto com este nome");
            }
            return produtoRepository.save(produto);
        } catch (Exception produtoException) {
            System.out.println("O erro ocorrido foi: " + produtoException.getMessage());
            throw produtoException;
        }

    }

    public ProdutoDTO getById(Long id) throws Exception {
        try {
            if (id == null || id < 1) {
                throw new Exception("O id do produto é inválido");
            }
            Optional<Produto> produtoOptional = produtoRepository.findById(id);
            if (produtoOptional.isPresent()) {
                Produto produto = produtoOptional.get();
                ProdutoDTO produtoDTO = new ProdutoDTO();
                produtoDTO.setNome(produto.getNome());
                produtoDTO.setDescricao(produto.getDescricao());
                produtoDTO.setPrecoUnitario(produto.getPrecoUnitario());
                produtoDTO.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque());
                produtoDTO.setCategoriaId(produto.getCategoria().getId());
                return produtoDTO;
            } else {
                throw new Exception("Produto não encontrado");
            }
        } catch (Exception produtoException) {
            System.out.println("Ocorreu o seguinte erro: " + produtoException.getMessage());
            throw produtoException;
        }
    }

public Page<ProdutoDTO> listarTodos(Pageable pageable) {
    Page<Produto> produtos = produtoRepository.findAll(pageable);

    return produtos.map(produto -> {
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setNome(produto.getNome());
        produtoDTO.setDescricao(produto.getDescricao());
        produtoDTO.setPrecoUnitario(produto.getPrecoUnitario());
        produtoDTO.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque());
        produtoDTO.setCategoriaId(produto.getCategoria().getId());
        return produtoDTO;
    });
}





}
