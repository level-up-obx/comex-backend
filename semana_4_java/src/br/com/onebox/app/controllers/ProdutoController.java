package br.com.onebox.app.controllers;

import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.domain.Produto;
import br.com.onebox.app.dtos.ProdutoDTO;
import br.com.onebox.app.repositories.CategoriaRepository;
import br.com.onebox.app.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto cadastrarProduto(@RequestBody @Valid ProdutoDTO produtoDTO) {
        Categoria categoria = categoriaRepository.findById(produtoDTO.getIdCategoria())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria Inválida"));

        Produto produto = new Produto();
        produto.setNome(produtoDTO.getNome());
        produto.setPrecoUnitario(produtoDTO.getPrecoUnitario());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setQuantidadeEstoque(produtoDTO.getQuantidadeEstoque());
        produto.setCategoria(categoria);

        return produtoRepository.save(produto);
    }

}
