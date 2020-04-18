package cz.czechitas.webapp;

import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HlavniController {

    private static final List<Contact> CONTACT_LIST = Arrays.asList(

            new Contact(100L, "Nikola Tesla", "+1 - 123-444-666", "nikola@tesla.com"),
            new Contact(101L, "Lea Baekelanda", "+421 -66-4443-22", "lea@baekelanda.com"),
            new Contact(102L, "Alan Turing", "+322 - 356-77", "alan@turning.com")
    );

    @RequestMapping("/")
    public ModelAndView zobrazIndex() {
        ModelAndView modelAndViewHandler = new ModelAndView("index");
        modelAndViewHandler.addObject("contactList", CONTACT_LIST);

        return modelAndViewHandler;
    }

    @RequestMapping("/{id}")
    public ModelAndView zobrazIndex(@PathVariable Long id) {
        int index = findIndex(id);
        Contact contact = CONTACT_LIST.get(index);

        ModelAndView modelAndViewHandler = new ModelAndView("detail");
        modelAndViewHandler.addObject("contact", contact);

        return modelAndViewHandler;
    }

    private int findIndex(Long id) {
        for (int i = 0; i < CONTACT_LIST.size(); i++) {
            Contact contact = CONTACT_LIST.get(i);
            if (contact.getId().equals(id)) {
                return i;
            }
        }

        return -1;

    }
}
