package cl.abpro.SecAbpro.service.impl;

import cl.abpro.SecAbpro.model.ClientEntity;
import cl.abpro.SecAbpro.model.Visita;
import cl.abpro.SecAbpro.persistence.IVisitaDAO;
import cl.abpro.SecAbpro.service.IVisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VisitaServiceImpl implements IVisitaService {
    @Autowired
    IVisitaDAO vDAO;

    @Override
    public List<Visita> findAll() {
        return vDAO.findAll();
    }

    @Override
    public Optional<Visita> findById(Long id) {
        return vDAO.findById(id);
    }

    @Override
    public Optional<Visita> findByCliente(ClientEntity cliente) {
        return vDAO.findByCliente(cliente);
    }

    @Override
    public void save(Visita visita) {
        vDAO.save(visita);
    }

    @Override
    public void deleteById(Long id) {
        vDAO.deleteById(id);
    }
}
