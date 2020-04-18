package cz.czechitas.webapp;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HlavniController {

    @RequestMapping(value ="/", method = RequestMethod.GET)

    public ModelAndView zobrazIndex() {
        ModelAndView modelAndViewhandler = new  ModelAndView("index")  ;
        return modelAndViewhandler;
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView zobrazResult(JmenoForm vyplnenyFormular) {
        ModelAndView modelAndViewhandler = new  ModelAndView("result")  ;
        String name =
                vyplnenyFormular.getFirstName()
                 + " "
                 + vyplnenyFormular.getFirstName();

        // pridanie klucu pre thymeleaf
        modelAndViewhandler.addObject("celeJmeno", name);
        return modelAndViewhandler;
    }

}
