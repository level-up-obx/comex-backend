package br.com.onebox.app.api.produto;

import br.com.onebox.app.domain.Produto;
import br.com.onebox.app.repository.CategoriaRepository;
import br.com.onebox.app.repository.ProdutoRepository;
import br.com.onebox.app.service.ProdutoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoDto> salvar(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriComponentsBuilder){
        Produto produto = form.toEntity(categoriaRepository);
        produtoRepository.save(produto);
        URI uri = uriComponentsBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoDto((produto)));
    }

    @GetMapping
    public Page<ProdutoDto> listarOrdenado(@PageableDefault(size = 5, sort = "nome", direction = Sort.Direction.ASC) Pageable pageable){
        Page<Produto> produtos = produtoRepository.findAll(pageable);
        return produtos.map(Produto::converter);
    }
}
