package br.com.onebox.app.repository;

import br.com.onebox.app.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findAll();
    @Query("SELECT c FROM Cliente c WHERE CONCAT(c.primeiroNome, ' ', c.sobrenome) LIKE :nome")
    List<Cliente> listaPorNome(@Param("nome") String nome);

}
