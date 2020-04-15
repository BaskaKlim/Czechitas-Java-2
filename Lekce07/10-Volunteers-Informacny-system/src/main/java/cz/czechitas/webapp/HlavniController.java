package cz.czechitas.webapp;

import java.util.*;
import java.util.concurrent.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HlavniController {
    VolunteersRepository volunteers = new VolunteersRepository();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showHomepage() {
        ModelAndView modelAndViewHandler = new ModelAndView("inde");
           modelAndViewHandler.addObject("volunteers",volunteers.showVolunteers());
       return modelAndViewHandler;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView takeRegistrationFata(RegistrationForm registrationFormData) {
        ModelAndView modelAndViewHandler = new ModelAndView("registration");
        modelAndViewHandler.addObject("volunteers",new RegistrationForm());
        return modelAndViewHandler;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView spracujNew(RegistrationForm registrationFormData) {
        volunteers.saveVolunteer(registrationFormData);
        return new ModelAndView("redirect:/");
    }


}
