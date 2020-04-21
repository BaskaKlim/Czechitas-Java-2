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


    @RequestMapping(value = "/booklibrary", method = RequestMethod.GET)
    public ModelAndView zobrazLibrary() {
        ModelAndView modelAndViewhandler = new ModelAndView("inde");
        //adding object to MVC articles, that i want to use in thymeleaf in html
        modelAndViewhandler.addObject("library", library.showLibrary());
        return modelAndViewhandler;
    }
    
    @RequestMapping(value = "/booklibrary/{keyNumber}", method = RequestMethod.POST, params = "_method=DELETE")
    public ModelAndView zmazBook(@PathVariable("keyNumber") Long keyNumber) {
        library.deleteBook(keyNumber);
        return new ModelAndView("redirect:/booklibrary");
    }


    //variable path calling from server - bookdetail1, bookdetail 2, bookdetail3 ...
    @RequestMapping(value = "/detail{keyNumber}", method = RequestMethod.GET)
    public ModelAndView zobrazDetail(@PathVariable("keyNumber") Long keyNumber) {
        ModelAndView modelAndViewhandler = new ModelAndView("detail");
        //adding object to MVC articles, that i want to use in thymeleaf in html
        modelAndViewhandler.addObject("book",library.showBookDetail(keyNumber));
        return modelAndViewhandler;
    }




}