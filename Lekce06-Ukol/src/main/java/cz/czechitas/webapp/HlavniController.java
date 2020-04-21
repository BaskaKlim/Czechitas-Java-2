package cz.czechitas.webapp;

import java.io.*;
import java.util.*;
import org.springframework.core.io.*;
import org.springframework.core.io.support.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HlavniController {
    //sestavit seznam jmen souborů automaticky (podle obsahu složky) pomocou Spring Framework třídu ResourcePatternResolver.

    private List<String> images;

    public HlavniController() throws IOException {
        ResourcePatternResolver fileSearcher = new PathMatchingResourcePatternResolver();
        List<Resource> resources = Arrays.asList(fileSearcher.getResources("classpath:/static/images/faces/*"));

        images = new ArrayList<>(resources.size());
        for (Resource prvek : resources) {
            images.add(prvek.getFilename());
        }

    }

        @RequestMapping(value = "/", method = RequestMethod.GET)

    public ModelAndView zobrazIndex() {
        ModelAndView modelAndViewhandler = new ModelAndView("inde");
        Collections.shuffle(images);

        modelAndViewhandler.addObject("images", images);
        return modelAndViewhandler;
    }




}

