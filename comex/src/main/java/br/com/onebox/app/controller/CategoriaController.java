package br.com.onebox.app.controller;

import br.com.onebox.app.controller.form.CategoriaForm;
import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.repository.CategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;
    
    public ResponseEntity<CategoriaForm> cadastrar(@RequestBody @Valid CategoriaForm form, UriComponentsBuilder uriComponentsBuilder){
        Categoria categoria = form.converter();
        categoriaRepository.save(categoria);
        URI uri = uriComponentsBuilder.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(new CategoriaForm());
    }
}
