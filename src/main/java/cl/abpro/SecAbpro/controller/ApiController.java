package cl.abpro.SecAbpro.controller;

import cl.abpro.SecAbpro.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ApiController {
    @Autowired
    UserServiceImpl us;

    @GetMapping("/prueba1")
    public String prueba1(){
        return "No Asegurado";
    }

    @GetMapping("/prueba2")
    public String prueba2(){
        return "Asegurado";
    }
}
