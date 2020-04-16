package cz.czechitas.webapp;

import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HlavniController {

    @RequestMapping("/")
    public ModelAndView zobrazIndex() {
        ModelAndView drzakNaDataAMenoSablony = new ModelAndView("index");
        List<Hrac> hraci = new ArrayList<>();
        hraci.add(new Hrac("Barbara","Klimek",31));
        hraci.add(new Hrac("Luba","Tomat",32));
        hraci.add(new Hrac("Vito","Oregano",18));

        drzakNaDataAMenoSablony.addObject("hraci", hraci);
        
        return drzakNaDataAMenoSablony;
    }

}
