package cz.czechitas.webapp;

import java.time.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HlavniController {

    @RequestMapping("/")
    public ModelAndView zobrazIndex() {
        ModelAndView modelAndViewHandler = new ModelAndView("index");

        LocalDate datum = LocalDate.now();
        LocalTime cas = LocalTime.now();

        modelAndViewHandler.addObject("datum", datum);
        modelAndViewHandler.addObject("cas", cas);
        return modelAndViewHandler;
    }
}
