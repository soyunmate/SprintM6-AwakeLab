package cl.abpro.SecAbpro.persistence.impl;

import cl.abpro.SecAbpro.model.Capacitacion;
import cl.abpro.SecAbpro.persistence.ICapacitacionDAO;
import cl.abpro.SecAbpro.repository.CapacitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class CapacitacionDAOImpl implements ICapacitacionDAO {
    @Autowired
    private CapacitacionRepository cRepo;
    @Override
    public List<Capacitacion> findAll() {
        return (List<Capacitacion>) cRepo.findAll();
    }

    @Override
    public Optional<Capacitacion> findByID(Long id) {
        return cRepo.findById(id);
    }

    @Override
    public void save(Capacitacion capacitacion) {
            cRepo.save(capacitacion);
    }

    @Override
    public void deleteById(Long id) {
        cRepo.deleteById(id);
    }
}
