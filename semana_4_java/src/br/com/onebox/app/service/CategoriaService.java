package br.com.onebox.app.service;
import br.com.onebox.app.CategoriaInvalidaException;
import br.com.onebox.app.domain.Categoria;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoriaService {
    private List<Categoria> categorias = new ArrayList<>();

    public void cadastrar(Categoria novaCategoria) throws CategoriaInvalidaException {
        if (novaCategoria == null) {
            throw new CategoriaInvalidaException("Categoria não pode ser NULA.");
        }
        if (novaCategoria.getNome() == null || novaCategoria.getNome().trim().isEmpty()) {
            throw new CategoriaInvalidaException("Nome não pode ser VAZIO ou NULO.");
        }
        categorias.add(novaCategoria);
    }

    public Optional<Categoria> get(int id) throws CategoriaInvalidaException {
        if (id <= 0) throw new CategoriaInvalidaException("ID não pode ser NEGATIVO ou NULO");
        return categorias.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }
}