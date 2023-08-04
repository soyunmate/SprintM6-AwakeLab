package cl.abpro.SecAbpro.repository;

import cl.abpro.SecAbpro.model.ClientEntity;
import cl.abpro.SecAbpro.model.ProfEntity;
import cl.abpro.SecAbpro.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProfRepository extends CrudRepository<ProfEntity, Long> {
    ProfEntity findByUser(UserEntity user);

    void deleteByUser(UserEntity user);
}
