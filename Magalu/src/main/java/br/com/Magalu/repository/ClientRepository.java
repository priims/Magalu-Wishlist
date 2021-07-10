package br.com.Magalu.repository;

import br.com.Magalu.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Boolean existsByCpf(String cpf);
}
