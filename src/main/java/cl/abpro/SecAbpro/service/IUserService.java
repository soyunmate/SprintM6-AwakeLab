package cl.abpro.SecAbpro.service;

import cl.abpro.SecAbpro.model.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserEntity> findAll();
    Optional<UserEntity> findByID(Long id);

    UserEntity findByUsername(String username);
    void save(UserEntity userEntity);
    void deleteById(Long id);
}
