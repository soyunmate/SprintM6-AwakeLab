package cl.abpro.SecAbpro.repository;

import cl.abpro.SecAbpro.model.Capacitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface CapacitacionRepository extends CrudRepository<Capacitacion, Long> {
}
