package cl.abpro.SecAbpro.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public ModelAndView handleError(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");

        // Obtener el mensaje y el código de estado del error
        String errorMessage = null;
        String errorStatus = null;

        // Puedes obtener el mensaje y el código de estado desde el request, por ejemplo:
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Object message = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);

        if (status != null) {
            errorStatus = "Status " + status.toString();
        }

        if (message != null) {
            errorMessage = message.toString();
        }

        // Agregar los atributos al modelo para que se muestren en la página de error
        modelAndView.addObject("errorMessage", errorMessage);
        modelAndView.addObject("errorStatus", errorStatus);

        return modelAndView;
    }


    public String getErrorPath() {
        return PATH;
    }
}
