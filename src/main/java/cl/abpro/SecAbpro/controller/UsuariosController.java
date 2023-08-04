package cl.abpro.SecAbpro.controller;

import cl.abpro.SecAbpro.controller.DTO.UsuarioDTO;
import cl.abpro.SecAbpro.model.*;
import cl.abpro.SecAbpro.repository.AdminRepository;
import cl.abpro.SecAbpro.repository.ClientRepository;
import cl.abpro.SecAbpro.repository.ProfRepository;
import cl.abpro.SecAbpro.service.impl.UserServiceImpl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    ClientRepository cRepo;
    @Autowired
    AdminRepository aRepo;
    @Autowired
    ProfRepository pRepo;

    @Autowired
    PasswordEncoder passwordEncoder;
    @GetMapping("/listar")
    public String listarUsuario(Model model) {
        List<UserEntity> listado = userService.findAll();

        List<UsuarioDTO> listadoDTO = listado.stream()
                .map(user -> new UsuarioDTO(
                        user.getId(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getRoles()))
                .toList();

        model.addAttribute("listado",listadoDTO);
        return "ListarUsuarios";
    }

    @GetMapping("/crear")
    public String crearUsuario() {
        return "CrearUsuario";
    }

    @PostMapping("/crear")
    public String crearAction(@RequestParam String nombre,
                              @RequestParam String pw,
                              @RequestParam String email,
                              @RequestParam String tipo,
                              @RequestParam(required = false) String rut,
                              @RequestParam(required = false) String area,
                              @RequestParam(required = false) String titulo) {

        UserEntity userEntity = UserEntity.builder()
                .username(nombre)
                .password(passwordEncoder.encode(pw))
                .email(email)
                .tipo(TipoUsuario.valueOf(tipo))
                .roles(Set.of(RoleEntity.builder()
                        .name(ERole.valueOf(String.valueOf(TipoUsuario.valueOf(tipo))))
                        .build()))
                .build();

        switch (tipo) {
            case "CLIENTE":
                ClientEntity newClient = ClientEntity.builder()
                        .rut(rut)
                        .user(userEntity)
                        .build();
                userService.save(userEntity);
                cRepo.save(newClient);
                break;
            case "ADMINISTRATIVO":
                AdminEntity newAdmin = AdminEntity.builder()
                        .area(area)
                        .user(userEntity)
                        .build();
                userService.save(userEntity);
                aRepo.save(newAdmin);
                break;
            case "PROFESIONAL":
                ProfEntity newProf = ProfEntity.builder()
                        .titulo(titulo)
                        .user(userEntity)
                        .build();
                userService.save(userEntity);
                pRepo.save(newProf);
                break;
            default:
                return "error";
        }



        return "redirect:/usuarios/listar";
    }

    @PostMapping("/editar")
    @Transactional
    public String editarUser(@RequestParam Long userid,
                             @RequestParam String nombre,
                             @RequestParam String pw,
                             @RequestParam String email,
                             @RequestParam String tipo,
                             @RequestParam(required = false) String rut,
                             @RequestParam(required = false) String area,
                             @RequestParam(required = false) String titulo) {

        Optional<UserEntity> optionalUser = userService.findByID(userid);

        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();
            TipoUsuario oldTipo = user.getTipo();

            switch (tipo) {
                case "CLIENTE" -> {
                    ClientEntity updatedClient = ClientEntity.builder()
                            .rut(rut)
                            .user(user)
                            .build();

                    if (oldTipo.name().equals("CLIENTE")) {
                        updatedClient.setId(cRepo.findByUser(user).getId());
                    } else {

                        Optional<ProfEntity> optProf = Optional.ofNullable(pRepo.findByUser(user));
                        optProf.ifPresent(profEntity -> pRepo.deleteById(profEntity.getId()));

                        Optional<AdminEntity> optAdmin = Optional.ofNullable(aRepo.findByUser(user));
                        optAdmin.ifPresent(adminEntity -> aRepo.deleteById(adminEntity.getId()));

                    }

                    cRepo.save(updatedClient);

                }
                case "ADMINISTRATIVO" -> {
                    AdminEntity updatedAdmin = AdminEntity.builder()
                            .area(area)
                            .user(user)
                            .build();

                    if (oldTipo.name().equals("ADMINISTRATIVO")) {
                        updatedAdmin.setId(aRepo.findByUser(user).getId());
                    } else {
                        Optional<ProfEntity> optProf = Optional.ofNullable(pRepo.findByUser(user));
                        optProf.ifPresent(profEntity -> pRepo.deleteById(profEntity.getId()));

                        Optional<ClientEntity> optClien = Optional.ofNullable(cRepo.findByUser(user));
                        optClien.ifPresent(clientEntity -> cRepo.deleteById(clientEntity.getId()));

                    }

                    aRepo.save(updatedAdmin);

                }
                case "PROFESIONAL" -> {
                    ProfEntity updatedProf = ProfEntity.builder()
                            .titulo(titulo)
                            .user(user)
                            .build();

                    if (oldTipo.name().equals("PROFESIONAL")) {
                        updatedProf.setId(pRepo.findByUser(user).getId());
                    } else {
                        Optional<ClientEntity> optClien = Optional.ofNullable(cRepo.findByUser(user));
                        optClien.ifPresent(clientEntity -> cRepo.deleteById(clientEntity.getId()));

                        Optional<AdminEntity> optAdmin = Optional.ofNullable(aRepo.findByUser(user));
                        optAdmin.ifPresent(adminEntity -> aRepo.deleteById(adminEntity.getId()));
                    }

                    pRepo.save(updatedProf);
                }
                default -> {
                    return "error";
                }
            }

            user.setUsername(nombre);
            user.setPassword(pw);
            user.setEmail(email);
            user.setTipo(TipoUsuario.valueOf(tipo));
            user.setRoles( user.getRoles().stream().filter(role -> role.getName().name().equals(tipo) ).collect(Collectors.toSet()));
            userService.save(user);

        }


        return "redirect:/usuarios/listar";
    }

}
