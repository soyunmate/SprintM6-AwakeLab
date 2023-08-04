package cl.abpro.SecAbpro.controller;

import cl.abpro.SecAbpro.model.Capacitacion;
import cl.abpro.SecAbpro.service.ICapacitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/capacitacion")
public class CapacitacionController {
    @Autowired
    ICapacitacionService capacitacionService;
        @GetMapping("/listar")
        public String listarCaps(Model model) {

            model.addAttribute("listado", capacitacionService.findAll());

            return "ListarCapacitaciones";
        }

        @GetMapping("/crear")
        public String crearCapForm() {
            return "CrearCapacitacion";
        }

        @PostMapping("/crear")
    public String crearCap(@RequestParam String nombre,
                           @RequestParam String detalle) {
            Capacitacion newCap = Capacitacion.builder()
                    .nombre(nombre)
                    .detalle(detalle)
                    .build();

            capacitacionService.save(newCap);
            return "redirect:/capacitacion/listar";
        }



}
