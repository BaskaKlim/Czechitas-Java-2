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
    public ModelAndView zobrazResult(VypoctyForm vyplnenyForm) {

        ModelAndView modelAndViewhandler = new  ModelAndView("result")  ;


        // pridanie klucu pre thymeleaf
        modelAndViewhandler.addObject("cislo1", vyplnenyForm.getCislo1());
        modelAndViewhandler.addObject("cislo2", vyplnenyForm.getCislo2());

        // vypocty - logicke operacie patria do MVC class nie do gettrov a settrov

        double sucet =  vyplnenyForm.getCislo1() + vyplnenyForm.getCislo2();
        double rozdiel =  vyplnenyForm.getCislo1() - vyplnenyForm.getCislo2();
        double sucin =  vyplnenyForm.getCislo1() * vyplnenyForm.getCislo2();
        double podiel =  vyplnenyForm.getCislo1() / vyplnenyForm.getCislo2();

        // pridanie klucu pre thymeleaf
        modelAndViewhandler.addObject("sucet",sucet);
        modelAndViewhandler.addObject("rozdiel",rozdiel);
        modelAndViewhandler.addObject("sucin",sucin);
        modelAndViewhandler.addObject("podiel",podiel);

        return modelAndViewhandler;
    }

}
