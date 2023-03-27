package br.com.onebox.app.controller;

import br.com.onebox.app.dtos.CategoriaNomeDTO;
import br.com.onebox.app.entity.Categoria;
import br.com.onebox.app.service.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;
    private ModelMapper modelMapper;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/categoria")
    public ResponseEntity<CategoriaNomeDTO> cadastrarCategoria(@RequestBody CategoriaNomeDTO categoriaNomeDTO) {
        try {
            Categoria categoria = categoriaService.cadastrar(categoriaNomeDTO);
            CategoriaNomeDTO categoriaNomePostDTO = modelMapper.map(categoria, CategoriaNomeDTO.class);
            return ResponseEntity.ok(categoriaNomePostDTO);
        } catch (Exception postCategoriaException) {
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

}
