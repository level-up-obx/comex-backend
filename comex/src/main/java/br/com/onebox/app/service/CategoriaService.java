package br.com.onebox.app.service;

import br.com.onebox.app.api.categoria.CategoriaDto;
import br.com.onebox.app.api.categoria.CategoriaForm;
import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.exception.CategoriaInvalidaException;
import br.com.onebox.app.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;
    public Categoria cadastrar(CategoriaForm categoriaForm) throws CategoriaInvalidaException {
        try {
            if (categoriaForm.equals(null)) {
                throw new CategoriaInvalidaException("Categoria Inválida, valores nulos encontrados!");
            }
        } catch (CategoriaInvalidaException e) {
            System.out.println(e.getMessage());
        }
        Categoria categoria = categoriaForm.toEntity();
        return categoriaRepository.save(categoria);
    }
    public List<CategoriaDto> getCategorias() {

        List<Categoria> categorias = new ArrayList<>();
        categoriaRepository.findAll().forEach(categorias::add);

        return CategoriaDto.converter(categorias);
    }

    public CategoriaDto get(Long id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);

        Categoria categoria = obj.orElse(new Categoria());

        return CategoriaDto.converter(categoria);
    }
}
