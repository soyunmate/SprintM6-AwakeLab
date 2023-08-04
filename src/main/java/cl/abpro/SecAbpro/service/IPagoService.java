package cl.abpro.SecAbpro.service;

import cl.abpro.SecAbpro.model.Pago;

import java.util.List;
import java.util.Optional;

public interface IPagoService {
    List<Pago> findAll();
    Optional<Pago> findByID(Long id);
    void save(Pago pago);
    void deleteById(Long id);
}
