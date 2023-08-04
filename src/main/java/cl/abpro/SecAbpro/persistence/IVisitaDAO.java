package cl.abpro.SecAbpro.persistence;

import cl.abpro.SecAbpro.model.ClientEntity;
import cl.abpro.SecAbpro.model.Visita;

import java.util.List;
import java.util.Optional;

public interface IVisitaDAO {

    List<Visita> findAll();
    Optional<Visita> findById(Long id);
    Optional<Visita> findByCliente(ClientEntity cliente);

    void save(Visita visita);

    void deleteById(Long id);

}
