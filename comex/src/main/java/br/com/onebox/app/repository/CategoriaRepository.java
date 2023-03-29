package br.com.onebox.app.repository;

import br.com.onebox.app.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
