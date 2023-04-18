package br.com.onebox.app.service;

import br.com.onebox.app.api.produto.ProdutoDto;
import br.com.onebox.app.api.produto.ProdutoForm;
import br.com.onebox.app.domain.Produto;
import br.com.onebox.app.exception.ProdutoInvalidoException;
import br.com.onebox.app.repository.CategoriaRepository;
import br.com.onebox.app.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;


    public Produto cadastrar(ProdutoForm produtoForm) throws ProdutoInvalidoException {
        try {
            if (produtoForm.equals(null) || produtoForm.getQuantidadeEmEstoque() <= 0) {
                throw new ProdutoInvalidoException("Produto inválido ou quantidade em estoque nula");
            }
        } catch (ProdutoInvalidoException e) {
            System.out.println(e.getMessage());
        }
        Produto produto = produtoForm.toEntity(categoriaRepository);
        return produtoRepository.save(produto);
    }

    public ProdutoDto buscarPorId(Long id) {
        return new ProdutoDto(produtoRepository.findById(id).orElseThrow());
    }

    public Page<Produto> listarTodos(Pageable pageable){
        return produtoRepository.findAll(pageable);
    }
}
