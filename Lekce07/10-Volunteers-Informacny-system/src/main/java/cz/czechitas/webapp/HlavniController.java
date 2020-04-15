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

}
