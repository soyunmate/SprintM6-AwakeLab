package cl.abpro.SecAbpro.service;

import cl.abpro.SecAbpro.model.Capacitacion;

import java.util.List;
import java.util.Optional;

public interface ICapacitacionService {
    List<Capacitacion> findAll();
    Optional<Capacitacion> findByID(Long id);
    void save(Capacitacion capacitacion);
    void deleteById(Long id);
}
