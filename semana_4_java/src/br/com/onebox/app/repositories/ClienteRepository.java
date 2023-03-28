package br.com.onebox.app.repositories;
import br.com.onebox.app.domain.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Optional<Cliente> findById(Long id);
    List<Cliente> findByPrimeiroNomeAndSobrenome(String primeiroNome, String sobrenome);
}
