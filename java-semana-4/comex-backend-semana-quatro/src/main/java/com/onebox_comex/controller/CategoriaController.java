package com.onebox_comex.controller;

import com.onebox_comex.dtos.CategoriaNomeDTO;
import com.onebox_comex.dtos.VendasCategoriaDTO;
import com.onebox_comex.entity.Categoria;
import com.onebox_comex.service.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<CategoriaNomeDTO> cadastrarCategoria(@RequestBody CategoriaNomeDTO categoriaNomeDTO) {
        try {
            Categoria categoria = categoriaService.cadastrar(categoriaNomeDTO);
            CategoriaNomeDTO categoriaNomePostDTO = new CategoriaNomeDTO();
            categoriaNomePostDTO.setNome(categoria.getNome());
            return ResponseEntity.ok(categoriaNomePostDTO);
        } catch (Exception postCategoriaException) {
            postCategoriaException.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaNomeDTO> getById(@PathVariable Long id) {
        try {
            CategoriaNomeDTO categoria = categoriaService.getById(id);
            return ResponseEntity.ok(categoria);
        } catch (Exception getByIdException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/vendas")
    public List<VendasCategoriaDTO> obterVendasPorCategoria() {
        return categoriaService.obterVendasPorCategoria();
    }
}

