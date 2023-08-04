package cl.abpro.SecAbpro.security;

import cl.abpro.SecAbpro.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {

    @Autowired
    UserDetailsServiceImpl userDetailsService;


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/home","/","/inicio","/index").permitAll()
                        .requestMatchers("/api/v1/**").permitAll()
                        .requestMatchers("/api/v1/capacitaciones/crear").permitAll()
                        .requestMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**").permitAll()
                        .requestMatchers("/capacitacion/**", "/contacto").hasRole("CLIENTE")
                        .requestMatchers("/usuarios/**").hasRole("ADMINISTRATIVO")
                        .requestMatchers("/visitas/**").hasRole("PROFESIONAL")
                        .anyRequest().authenticated()
                )
                .formLogin(formlogin -> formlogin
                        .permitAll()
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true))
                .logout(logout -> logout
                        .permitAll()
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true"))
                .build();

    }




    /*
	@Bean
	AuthenticationManager authenticationManager(HttpSecurity httpSecurity,
												PasswordEncoder passwordEncoder) throws Exception {
		return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder)
				.and().build();

	}
	*/

}
