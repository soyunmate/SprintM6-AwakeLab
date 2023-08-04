package cl.abpro.SecAbpro.controller;

import cl.abpro.SecAbpro.model.Pago;
import cl.abpro.SecAbpro.service.IPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/pagos")
public class PagoController {
    @Autowired
    private IPagoService pagoService;
    @GetMapping("/listar")
    private String listarPagos(Model model) {
        List<Pago> listado = pagoService.findAll();
        model.addAttribute("listado",listado);
        return "ListarPagos";
    }


    @GetMapping("/crear")
    private String crearPagoForm() {
        return "CrearPago";
    }

    @PostMapping("/crear")
    private String crearPago(@RequestParam String detalle, @RequestParam Long monto) {
        Pago newPago = Pago.builder()
                .detalle(detalle)
                .monto(monto)
                .build();

        pagoService.save(newPago);

        return "redirect:/pagos/listar";
    }
}
