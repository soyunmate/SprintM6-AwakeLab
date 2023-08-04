package cl.abpro.SecAbpro.service.impl;

import cl.abpro.SecAbpro.model.UserEntity;
import cl.abpro.SecAbpro.persistence.IUserDAO;
import cl.abpro.SecAbpro.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDAO userDAO;

    @Override
    public List<UserEntity> findAll() {
        return userDAO.findAll();
    }

    @Override
    public Optional<UserEntity> findByID(Long id) {
        return userDAO.findByID(id);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    public void save(UserEntity userEntity) {
        userDAO.save(userEntity);
    }

    @Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }
}
