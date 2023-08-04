package cl.abpro.SecAbpro.repository;

import cl.abpro.SecAbpro.model.ClientEntity;
import cl.abpro.SecAbpro.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientEntity, Long> {
    ClientEntity findByUser(UserEntity user);

    void deleteByUser(UserEntity user);
}
