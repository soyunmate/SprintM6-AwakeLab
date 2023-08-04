package cl.abpro.SecAbpro.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PrincipalController {
    @Autowired
    private HttpServletRequest request;

    @GetMapping(path = {"/","/home","/index"})
    public String home(Model model) {
        model.addAttribute("request", request);
        return "inicio";
    }

    @GetMapping("/contacto")
    public String contactPage() {
        return "contacto";
    }


    @GetMapping("/login")
    public String loginPage() {

        //logout.isBlank() ? isLoggedOut = true : isLoggedOut = false;
        return "login";
    }



   /* @GetMapping("/logout")
    public String logoutPage() {
        return "login";
    }*/
}
