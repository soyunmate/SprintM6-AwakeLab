package cl.abpro.SecAbpro.controller;

import cl.abpro.SecAbpro.controller.DTO.VisitaDTO;
import cl.abpro.SecAbpro.model.CheckListVisita;
import cl.abpro.SecAbpro.model.ClientEntity;
import cl.abpro.SecAbpro.model.Visita;
import cl.abpro.SecAbpro.repository.CheckListRepository;
import cl.abpro.SecAbpro.repository.ClientRepository;
import cl.abpro.SecAbpro.service.IVisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/visitas")
public class VisitaController {
    @Autowired
    IVisitaService vService;
    @Autowired
    ClientRepository cRepo;

    @Autowired
    CheckListRepository checkRepo;

    @GetMapping("/listar")
    public String listarVisitas(Model model) {

        List<VisitaDTO> listado = vService.findAll().stream().map(visita ->
                VisitaDTO.builder()
                        .id(visita.getId())
                        .name(visita.getName())
                        .cliente(visita.getCliente().getId())
                        .detalle(visita.getDetalle())
                        .build()
        ).toList();

        model.addAttribute("listado",listado);
        return "ListarVisitas";

    }

    @GetMapping("/crear")
    public String crearVisitaForm() {
        return "CrearVisita";
    }

    @PostMapping("/crear")
    public String crearVisita(@RequestParam Long clienteid,
                              @RequestParam String name,
                              @RequestParam String detalle) {

        Optional<ClientEntity> optClient = cRepo.findById(clienteid);
       if(optClient.isPresent()) {
           Visita newVisita = Visita.builder()
                   .name(name)
                   .detalle(detalle)
                   .cliente(optClient.get())
                   .build();
           vService.save(newVisita);
       } else {
           System.out.println("Cliente no encontrado");
       }

        return "redirect:/visitas/listar";
    }

    @PostMapping("/check")
    public String responderCheck(@RequestParam Long userid,
                                 @RequestParam(defaultValue = "false") String visitaExitosa,
                                 @RequestParam(defaultValue = "false") String cumpleQuorum,
                                 @RequestParam(defaultValue = "false") String superPresente,
                                 @RequestParam(defaultValue = "false") String cumpleProtocolo,
                                 @RequestParam(defaultValue = "false") String entregaInforme) {

        Optional<Visita> optVisita = vService.findById(userid);

        if (optVisita.isPresent()) {
            Visita visita = optVisita.get();
            CheckListVisita checkList = CheckListVisita.builder()
                    .visita(visita)
                    .visitaExitosa(Boolean.parseBoolean(visitaExitosa))
                    .cumpleQuorum(Boolean.parseBoolean(cumpleQuorum))
                    .superPresente(Boolean.parseBoolean(superPresente))
                    .cumpleProtocolo(Boolean.parseBoolean(cumpleProtocolo))
                    .entregaInforme(Boolean.parseBoolean(entregaInforme))
                    .build();
            checkRepo.save(checkList);
        }

        System.out.println(userid + " " + cumpleQuorum);

        return "redirect:/visitas/listar";
    }

}
