package br.com.onebox.app.repositories;
import br.com.onebox.app.domain.Categoria;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

}
