package cl.abpro.SecAbpro.repository;

import cl.abpro.SecAbpro.model.AdminEntity;
import cl.abpro.SecAbpro.model.ClientEntity;
import cl.abpro.SecAbpro.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<AdminEntity, Long> {
    AdminEntity findByUser(UserEntity user);

    void deleteByUser(UserEntity user);
}
