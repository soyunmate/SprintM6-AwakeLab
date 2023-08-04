package cl.abpro.SecAbpro.persistence;

import cl.abpro.SecAbpro.model.Pago;
import cl.abpro.SecAbpro.model.RoleEntity;

import java.util.List;
import java.util.Optional;

public interface IPagoDAO {
    List<Pago> findAll();
    Optional<Pago> findByID(Long id);
    void save(Pago pago);
    void deleteById(Long id);
}
