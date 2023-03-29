package br.com.onebox.app.controllers;

import br.com.onebox.app.entity.Categoria;
import br.com.onebox.app.entity.Produto;
import br.com.onebox.app.dtos.ProdutoDTO;
import br.com.onebox.app.repositories.CategoriaRepository;
import br.com.onebox.app.repositories.ProdutoRepository;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.List;

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

    @GetMapping
    public Page<ProdutoDTO> listarProdutos(@RequestParam(defaultValue = "0") int pagina) {
        Pageable pageable = PageRequest.of(pagina, 5, Sort.by("nome"));
        Page<Produto> produtos = produtoRepository.findAll(pageable);

        List<ProdutoDTO> produtosDTO = new ArrayList<>();
        for (Produto produto : produtos) {
            ProdutoDTO produtoDTO = new ProdutoDTO();
            produtoDTO.setNome(produto.getNome());
            produtoDTO.setPrecoUnitario(produto.getPrecoUnitario());
            produtoDTO.setDescricao(produto.getDescricao());
            produtoDTO.setQuantidadeEstoque(produto.getQuantidadeEstoque());
            produtoDTO.setIdCategoria(produto.getCategoria().getId());
            produtoDTO.setCategoriaNome(produto.getCategoria().getNome());
            produtosDTO.add(produtoDTO);
        }

        return new PageImpl<>(produtosDTO, pageable, produtos.getTotalElements());
    }


}
