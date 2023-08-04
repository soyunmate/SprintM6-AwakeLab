package cl.abpro.SecAbpro.persistence.impl;

import cl.abpro.SecAbpro.model.Pago;
import cl.abpro.SecAbpro.persistence.IPagoDAO;
import cl.abpro.SecAbpro.repository.PagosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class PagoDAOImpl implements IPagoDAO {

    @Autowired
    private PagosRepository pagoRepo;

    @Override
    public List<Pago> findAll() {
        return (List<Pago>) pagoRepo.findAll();
    }

    @Override
    public Optional<Pago> findByID(Long id) {
        return pagoRepo.findById(id);
    }

    @Override
    public void save(Pago pago) {
        pagoRepo.save(pago);
    }

    @Override
    public void deleteById(Long id) {
            pagoRepo.deleteById(id);
    }
}
