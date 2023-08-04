package cl.abpro.SecAbpro.persistence.impl;


import cl.abpro.SecAbpro.model.RoleEntity;
import cl.abpro.SecAbpro.persistence.IRoleDAO;
import cl.abpro.SecAbpro.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class RoleDAOImpl implements IRoleDAO {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public List<RoleEntity> findAll() {
        return (List<RoleEntity>) roleRepository.findAll();
    }

    @Override
    public Optional<RoleEntity> findByID(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public void save(RoleEntity roleEntity) {
        roleRepository.save(roleEntity);
    }

    @Override
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }
}
