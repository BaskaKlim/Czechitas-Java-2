package cz.czechitas.webapp;

import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HlavniController extends Player {

    @RequestMapping("/")
    public ModelAndView zobrazIndex() {
        ModelAndView drzakNaDataANazevSablony = new ModelAndView("index");
        return drzakNaDataANazevSablony;
    }


}
