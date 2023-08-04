package cl.abpro.SecAbpro.controller.API;

import cl.abpro.SecAbpro.controller.DTO.UsuarioDTO;
import cl.abpro.SecAbpro.model.UserEntity;
import cl.abpro.SecAbpro.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioApiController {
    @Autowired
    UserServiceImpl userService;

    @GetMapping("/listar")
    public ResponseEntity<?> listarUsuarios() {
        List<UserEntity> listado = userService.findAll();

        List<UsuarioDTO> listadoDTO = listado.stream()
                .map(user -> new UsuarioDTO(
                        user.getId(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getRoles()))
                .toList();

        return ResponseEntity.ok(listadoDTO);
    }
}
