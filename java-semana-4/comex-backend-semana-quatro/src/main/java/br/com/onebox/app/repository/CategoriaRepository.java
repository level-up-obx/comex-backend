package br.com.onebox.app.repository;

import br.com.onebox.app.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findAll();
    Optional<Categoria> findByNome(String nome);

}
