package br.com.onebox.app.api.categoria;

import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.repository.CategoriaRepository;
import br.com.onebox.app.repository.ProdutoRepository;
import br.com.onebox.app.service.CategoriaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    private CategoriaService categoriaService;
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/{id}")
    @ResponseBody
    public CategoriaDto get(@PathVariable("id") Long id) {
        return categoriaService.get(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaDto> cadastrar(@RequestBody @Valid CategoriaForm form, UriComponentsBuilder uriComponentsBuilder){
        Categoria categoria = form.toEntity();
        categoriaRepository.save(categoria);
        URI uri = uriComponentsBuilder.path("/api/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(new CategoriaDto(categoria));
    }

    @GetMapping("/vendas")
    @ResponseBody
    public List<Object> lista() {
        return produtoRepository.relatorioDeVendasPorCategoria();
    }
}
