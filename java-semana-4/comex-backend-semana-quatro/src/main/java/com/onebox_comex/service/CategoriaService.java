package com.onebox_comex.service;

import com.onebox_comex.dtos.CategoriaNomeDTO;
import com.onebox_comex.dtos.VendasCategoriaDTO;
import com.onebox_comex.repository.CategoriaRepository;
import com.onebox_comex.entity.Categoria;
import com.onebox_comex.repository.ItemPedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;
    private final ItemPedidoRepository itemPedidoRepository;

    private ModelMapper modelMapper;

    public CategoriaService(CategoriaRepository categoriaRepository, ItemPedidoRepository itemPedidoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public Categoria cadastrar(CategoriaNomeDTO categoriaNomeDTO) throws Exception {
        Optional<Categoria> categoriaOptional = categoriaRepository.findByNome(categoriaNomeDTO.getNome());
        try {
            if (categoriaOptional == null) {
                throw new Exception("Esta categoria é nula");
            }
            if (categoriaOptional.isEmpty()) {
                throw new Exception("Esta categoria está vazia");
            }
            if (categoriaOptional.isPresent()) {
                throw new Exception("Já existe uma categoria com este nome");
            }

            Categoria categoria = modelMapper.map(categoriaNomeDTO, Categoria.class);
            return categoriaRepository.save(categoria);

        } catch (Exception categoriaException) {
            System.out.println("O erro ocorrido foi: " + categoriaException.getMessage());
            throw categoriaException;
        }
    }

    public CategoriaNomeDTO getById(Long id) throws Exception {
        try {
            if (id == null || id < 1) {
                throw new Exception("O id não é válido, está nulo ou negativo");
            }

            Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
            if (categoriaOptional.isPresent()) {
                Categoria categoria = categoriaOptional.get();
                return modelMapper.map(categoria, CategoriaNomeDTO.class);
            } else {
                throw new Exception("Não foi possível encontrar a categoria com o id informado");
            }
        } catch (Exception categoriaException) {
            System.out.println("O erro ocorrido foi: " + categoriaException.getMessage());
            throw categoriaException;
        }
    }

    public List<VendasCategoriaDTO> obterVendasPorCategoria() {
        List<VendasCategoriaDTO> vendasCategoriaDTOList = new ArrayList<>();

        List<Categoria> categorias = categoriaRepository.findAll();
        for (Categoria categoria : categorias) {
            Long quantidadeProdutosVendidos = itemPedidoRepository.countQuantidadeProdutosPorCategoria(categoria.getId());
            BigDecimal montanteVendido = itemPedidoRepository.sumMontanteVendidoPorCategoria(categoria.getId());

            VendasCategoriaDTO vendasCategoriaDTO = new VendasCategoriaDTO();
            vendasCategoriaDTO.setNomeCategoria(categoria.getNome());
            vendasCategoriaDTO.setQuantidadeProdutosVendidos(quantidadeProdutosVendidos);
            vendasCategoriaDTO.setMontanteVendido(montanteVendido);

            vendasCategoriaDTOList.add(vendasCategoriaDTO);
        }

        return vendasCategoriaDTOList;

    }
}
