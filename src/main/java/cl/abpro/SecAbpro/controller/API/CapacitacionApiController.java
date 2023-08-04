package cl.abpro.SecAbpro.controller.API;

import cl.abpro.SecAbpro.controller.DTO.CapacitacionDTO;
import cl.abpro.SecAbpro.model.Capacitacion;
import cl.abpro.SecAbpro.service.ICapacitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/capacitaciones")
public class CapacitacionApiController {
    @Autowired
    private ICapacitacionService cService;

    @PostMapping("/crear")
    private ResponseEntity<?> crearCap(@RequestBody CapacitacionDTO capDTO) {
        Capacitacion newCap = new Capacitacion();

        newCap.setNombre(capDTO.getNombre());
        newCap.setDetalle(capDTO.getDetalle());

        cService.save(newCap);

        System.out.println(capDTO.toString());

        return  ResponseEntity.created(URI.create("api/v1/capacitaciones/crear")).build();
    }

    @GetMapping("/listar")
    private ResponseEntity<?> listarCap() {

        List<CapacitacionDTO> listado = cService.findAll().stream().map(
                cap -> CapacitacionDTO.builder()
                        .nombre(cap.getNombre())
                        .detalle(cap.getDetalle())
                        .build()
        ).toList();


        return  ResponseEntity.ok(listado);
    }


}
