package br.com.onebox.app.repository;

import br.com.onebox.app.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public List<Cliente> findAllByPrimeiroNome(String nome);
}
