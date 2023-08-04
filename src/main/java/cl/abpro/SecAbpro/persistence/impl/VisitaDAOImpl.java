package cl.abpro.SecAbpro.persistence.impl;

import cl.abpro.SecAbpro.model.ClientEntity;
import cl.abpro.SecAbpro.model.Visita;
import cl.abpro.SecAbpro.persistence.IVisitaDAO;
import cl.abpro.SecAbpro.repository.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VisitaDAOImpl implements IVisitaDAO {
    @Autowired
    VisitaRepository vRepo;

    @Override
    public List<Visita> findAll() {
        return (List<Visita>) vRepo.findAll();
    }

    @Override
    public Optional<Visita> findById(Long id) {
        return vRepo.findById(id);
    }

    @Override
    public Optional<Visita> findByCliente(ClientEntity cliente) {
        return vRepo.findByCliente(cliente);
    }

    @Override
    public void save(Visita visita) {
            vRepo.save(visita);
    }

    @Override
    public void deleteById(Long id) {
            vRepo.deleteById(id);
    }
}
