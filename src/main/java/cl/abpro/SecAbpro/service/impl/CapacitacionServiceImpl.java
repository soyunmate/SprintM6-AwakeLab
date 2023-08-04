package cl.abpro.SecAbpro.service.impl;

import cl.abpro.SecAbpro.model.Capacitacion;
import cl.abpro.SecAbpro.persistence.ICapacitacionDAO;
import cl.abpro.SecAbpro.service.ICapacitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CapacitacionServiceImpl implements ICapacitacionService {
    @Autowired
    private ICapacitacionDAO cDao;

    @Override
    public List<Capacitacion> findAll() {
        return cDao.findAll();
    }

    @Override
    public Optional<Capacitacion> findByID(Long id) {
        return cDao.findByID(id);
    }

    @Override
    public void save(Capacitacion capacitacion) {
            cDao.save(capacitacion);
    }

    @Override
    public void deleteById(Long id) {
            cDao.deleteById(id);
    }
}
