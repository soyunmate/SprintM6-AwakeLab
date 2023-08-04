package cl.abpro.SecAbpro.service.impl;



import cl.abpro.SecAbpro.model.UserEntity;
import cl.abpro.SecAbpro.persistence.IUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	IUserDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userDAO.findByUsername(username);
		
		if (user == null) {
	        throw new UsernameNotFoundException("Usuario no encontrado: " + username);
	    }
	    return new CustomUserDetails(user);
	}

}
