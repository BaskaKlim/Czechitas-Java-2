package cz.czechitas.webapp;

import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HlavniController {

    @RequestMapping("/")
    public ModelAndView zobrazIndex() {
        ModelAndView drzakNaDataAjmenoSablony = new ModelAndView("index") ;
        drzakNaDataAjmenoSablony.addObject("jmeno", "Barbara")   ; // natvrdo pridane meno,

        Random generatorCisel= new Random();
        int i = generatorCisel.nextInt(6)+1;

        drzakNaDataAjmenoSablony.addObject("cisloNaKostke",i);
        return drzakNaDataAjmenoSablony;
    }

}
















