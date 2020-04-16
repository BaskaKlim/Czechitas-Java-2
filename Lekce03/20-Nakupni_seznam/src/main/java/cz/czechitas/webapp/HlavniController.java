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
        List<String> nakupniSeznam = Arrays.asList(
                "Milk",
                "Tea",
                "Gin",
                "Lemons",
                "Mango"
                );

        drzakNaDataAMenoSablony.addObject("seznam", nakupniSeznam);
        return drzakNaDataAMenoSablony;
    }

}
