package br.com.onebox.app.api.produto;

import br.com.onebox.app.domain.Produto;
import br.com.onebox.app.repository.ProdutoRepository;
import br.com.onebox.app.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoDto> salvar(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriComponentsBuilder){
        Produto produto = form.toEntity();
        produtoRepository.save(produto);
        URI uri = uriComponentsBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoDto(Optional.of(produto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> listarOrdenado(@PathVariable Long id){
        ProdutoDto produto = produtoService.buscarPorId(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }
}
