package com.onebox_comex.controller;

import com.onebox_comex.dtos.CategoriaNomeDTO;
import com.onebox_comex.dtos.ProdutoDTO;
import com.onebox_comex.entity.Categoria;
import com.onebox_comex.entity.Produto;
import com.onebox_comex.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;
    private ModelMapper modelMapper;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/produto")
    public ResponseEntity<ProdutoDTO> cadastrarProduto(@RequestBody ProdutoDTO produtoDTO) {
        try {
            Produto produto = produtoService.cadastrar(produtoDTO);
            ProdutoDTO produtoPostDTO = modelMapper.map(produto, ProdutoDTO.class);
            return ResponseEntity.ok(produtoPostDTO);
        } catch (Exception postProdutoException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getById(@PathVariable Long id) {
        try {
            ProdutoDTO produto = produtoService.getById(id);
            return ResponseEntity.ok(produto);
        } catch (Exception getByIdException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
