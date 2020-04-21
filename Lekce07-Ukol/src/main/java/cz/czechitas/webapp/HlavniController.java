package cz.czechitas.webapp;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HlavniController {

    BookRepository library = new BookRepository();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView zobrazIndex() {
        //redirect to library web adesss
        return new ModelAndView("redirect:/booklibrary");
    }

  


}