package br.com.onebox.app.dao;
import br.com.onebox.app.domain.Categoria;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

    Optional<Categoria> findById(Long id);

    Categoria save(Categoria categoria);

    List<Categoria> findAll();

}
