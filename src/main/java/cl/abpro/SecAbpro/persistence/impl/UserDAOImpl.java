package cl.abpro.SecAbpro.persistence.impl;


import cl.abpro.SecAbpro.model.UserEntity;
import cl.abpro.SecAbpro.persistence.IUserDAO;
import cl.abpro.SecAbpro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class UserDAOImpl implements IUserDAO {
    @Autowired
    UserRepository userRepository;

    public List<UserEntity> findAll() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> findByID(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
