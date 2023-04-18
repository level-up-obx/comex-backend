package br.com.onebox.app.api.produto;

import br.com.onebox.app.domain.Produto;
import br.com.onebox.app.exception.ProdutoInvalidoException;
import br.com.onebox.app.repository.CategoriaRepository;
import br.com.onebox.app.repository.ProdutoRepository;
import br.com.onebox.app.service.ProdutoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoDto> salvar(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriComponentsBuilder) throws ProdutoInvalidoException {
        Produto produto = produtoService.cadastrar(form);
        URI uri = uriComponentsBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoDto((produto)));
    }

    @GetMapping
    public Page<Produto> listarOrdenado(@PageableDefault(size = 5, sort = "nome", direction = Sort.Direction.ASC) Pageable pageable){
        return produtoService.listarTodos(pageable);
    }
}
