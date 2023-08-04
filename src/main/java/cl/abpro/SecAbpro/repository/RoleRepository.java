package cl.abpro.SecAbpro.repository;

import cl.abpro.SecAbpro.model.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
}
