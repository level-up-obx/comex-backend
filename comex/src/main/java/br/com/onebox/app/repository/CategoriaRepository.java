package br.com.onebox.app.repository;

import br.com.onebox.app.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
