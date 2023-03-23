package br.com.onebox.app.repository;

import br.com.onebox.app.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    public Iterable<Cliente> findAllByName(String nome);
}
