package cz.czechitas.webapp;

import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HlavniController {

    List<Item> items = Arrays.asList(
            new Item("Gin", 15.99, 1),
            new Item("Grepfruit", 9.99, 3),
            new Item("Cakes", 29.99, 2),
            new Item("Muffins", 1.75, 15)
    );

    @RequestMapping("/")
    public ModelAndView showIndex() {
        ModelAndView modelAndViewHandler = new ModelAndView("index");
        modelAndViewHandler.addObject("items", items);
        return modelAndViewHandler;
    }

    @RequestMapping("/kosik")
    public ModelAndView showKosik() {
        ModelAndView modelAndViewHandler = new ModelAndView("kosik");
        List<Item> kosikZoznam = new ArrayList<>();
        kosikZoznam.add(items.get(0));
        kosikZoznam.add(items.get(3));

        //nazov template, list/iny objekt ktory menime na template
        modelAndViewHandler.addObject("basket", kosikZoznam);
        return modelAndViewHandler;
    }

}
