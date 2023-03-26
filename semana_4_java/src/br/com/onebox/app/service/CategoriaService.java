package br.com.onebox.app.service;
import br.com.onebox.app.exceptions.CategoriaInvalidaException;
import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.repositories.CategoriaRepository;
import br.com.onebox.app.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public void cadastrar(Categoria novaCategoria) throws CategoriaInvalidaException {
        if (novaCategoria == null) {
            throw new CategoriaInvalidaException("Categoria não pode ser NULA.");
        }
        if (novaCategoria.getNome() == null || novaCategoria.getNome().trim().isEmpty()) {
            throw new CategoriaInvalidaException("Nome não pode ser VAZIO ou NULO.");
        }if (novaCategoria.getNome().length() < 2) {
            throw new CategoriaInvalidaException("Nome deve ter pelo menos 2 caracteres.");
        }
        novaCategoria.setStatus(true);
        categoriaRepository.save(novaCategoria);
    }
}