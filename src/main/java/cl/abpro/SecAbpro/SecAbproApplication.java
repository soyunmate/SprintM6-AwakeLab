package cl.abpro.SecAbpro;

import cl.abpro.SecAbpro.model.ERole;
import cl.abpro.SecAbpro.model.RoleEntity;
import cl.abpro.SecAbpro.model.UserEntity;
import cl.abpro.SecAbpro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class SecAbproApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecAbproApplication.class, args);
	}

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;


	@Bean
	CommandLineRunner init() {
		return args -> {
			UserEntity userEntity = UserEntity.builder()
					.email("admin@gmail.com")
					.username("admin")
					.password(passwordEncoder.encode("1234"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.ADMIN.name()))
							.build()))
					.build();

			UserEntity userEntity2 = UserEntity.builder()
					.email("usuario@gmail.com")
					.username("user")
					.password(passwordEncoder.encode("1234"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.USER.name()))
							.build()))
					.build();

			UserEntity userEntity3 = UserEntity.builder()
					.email("usuario@gmail.com")
					.username("cliente")
					.password(passwordEncoder.encode("1234"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.CLIENTE.name()))
							.build()))
					.build();

			UserEntity userEntity4 = UserEntity.builder()
					.email("usuario@gmail.com")
					.username("administrativo")
					.password(passwordEncoder.encode("1234"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.ADMINISTRATIVO.name()))
							.build()))
					.build();

			UserEntity userEntity5 = UserEntity.builder()
					.email("usuario@gmail.com")
					.username("prof")
					.password(passwordEncoder.encode("1234"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.PROFESIONAL.name()))
							.build()))
					.build();


			userRepository.save(userEntity);
			userRepository.save(userEntity2);
			userRepository.save(userEntity3);
			userRepository.save(userEntity4);
			userRepository.save(userEntity5);





		};
	}



}
