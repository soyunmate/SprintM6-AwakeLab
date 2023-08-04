package cl.abpro.SecAbpro.service.impl;

import cl.abpro.SecAbpro.model.Pago;
import cl.abpro.SecAbpro.persistence.IPagoDAO;
import cl.abpro.SecAbpro.service.IPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PagoServiceImpl implements IPagoService {
    @Autowired
    private IPagoDAO pDAO;

    @Override
    public List<Pago> findAll() {
        return pDAO.findAll();
    }

    @Override
    public Optional<Pago> findByID(Long id) {
        return pDAO.findByID(id);
    }

    @Override
    public void save(Pago pago) {
            pDAO.save(pago);
    }

    @Override
    public void deleteById(Long id) {
        pDAO.deleteById(id);
    }
}
