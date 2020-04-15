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
        return drzakNaDataAjmenoSablony;
    }

}
