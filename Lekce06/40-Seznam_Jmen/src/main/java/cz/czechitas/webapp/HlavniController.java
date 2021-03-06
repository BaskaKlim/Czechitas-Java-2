package cz.czechitas.webapp;

import java.util.*;
import java.util.concurrent.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HlavniController {
    private List<String> seznamJmen;

    public HlavniController() {
        seznamJmen = new CopyOnWriteArrayList<>();
        seznamJmen.add("Albert Einstein");
        seznamJmen.add("Nikola Tesla");
        seznamJmen.add("Barbara Klimek");
        seznamJmen.add("Eliska Milek");
    }

    @RequestMapping("/")
    public ModelAndView zobrazIndex() {
        ModelAndView modelAndViewHandler = new ModelAndView("inde");
        modelAndViewHandler.addObject(
                "seznamJmen", seznamJmen);
        return modelAndViewHandler;

  
    }


    @RequestMapping(value = "/novy.html", method = RequestMethod.GET)
    public ModelAndView zobraNovy() {
        return new ModelAndView("novy");
    }

    @RequestMapping(value = "/novy.html", method = RequestMethod.POST)
    public ModelAndView pracujNovy(@RequestParam String jmeno) {
        seznamJmen.add(jmeno);
        return new ModelAndView("redirect:/");
    }

}
