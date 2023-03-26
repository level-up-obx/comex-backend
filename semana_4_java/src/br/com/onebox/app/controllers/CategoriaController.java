package br.com.onebox.app.controllers;

import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.exceptions.CategoriaInvalidaException;
import br.com.onebox.app.repositories.CategoriaRepository;
import br.com.onebox.app.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> cadastrar(@RequestBody Categoria novaCategoria) {
        try {
            categoriaService.cadastrar(novaCategoria);
            return new ResponseEntity<>(novaCategoria, HttpStatus.CREATED);
        } catch (CategoriaInvalidaException exception) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}