package br.com.onebox.app.repository;

import br.com.onebox.app.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findAll();
    Categoria findByNome(String nome);

}
