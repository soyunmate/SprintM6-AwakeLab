package cl.abpro.SecAbpro.repository;

import cl.abpro.SecAbpro.model.ClientEntity;
import cl.abpro.SecAbpro.model.Visita;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VisitaRepository extends CrudRepository<Visita, Long> {
    Optional<Visita> findByCliente(ClientEntity cliente);
}
