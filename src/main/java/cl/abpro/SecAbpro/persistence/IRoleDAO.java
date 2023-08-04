package cl.abpro.SecAbpro.persistence;



import cl.abpro.SecAbpro.model.RoleEntity;

import java.util.List;
import java.util.Optional;

public interface IRoleDAO {
    List<RoleEntity> findAll();
    Optional<RoleEntity> findByID(Long id);
    void save(RoleEntity roleEntity);
    void deleteById(Long id);
}
