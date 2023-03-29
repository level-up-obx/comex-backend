package br.com.onebox.app.service;

import br.com.onebox.app.api.categoria.CategoriaDto;
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
    public void cadastrar(Categoria novaCategoria) throws CategoriaInvalidaException {
        try {
            if (novaCategoria.equals(null)) {
                throw new CategoriaInvalidaException("Categoria Inválida, valores nulos encontrados!");
            }
            categoriaRepository.save(novaCategoria);
            System.out.println("Categoria cadastrada com sucesso");
        } catch (CategoriaInvalidaException e) {
            System.out.println(e.getMessage());
        }
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
