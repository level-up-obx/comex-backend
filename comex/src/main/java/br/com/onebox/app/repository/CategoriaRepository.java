package br.com.onebox.app.repository;

import br.com.onebox.app.domain.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
}
