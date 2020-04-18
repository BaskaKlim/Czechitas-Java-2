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

    private List<String> images;



    @RequestMapping("/")
    public ModelAndView zobrazIndex() {

        images = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
        images.add("man" + i + ".jpg");
        }

        Collections.shuffle(images);


        ModelAndView modelAndViewHandler = new ModelAndView("index");
        modelAndViewHandler.addObject("images", images);
        return modelAndViewHandler;
    }
}


/* //dynamicke pridanie obrazkov, nie na tvrdo ako Arrays.asList
 public HlavniController() throws IOException {
     images = new ArrayList<>();
     ResourcePatternResolver fileSearcher = new PathMatchingResourcePatternResolver();
     List<Resource> resources = Arrays.asList(
             fileSearcher.getResources("classpath:/static/images/faces/*"));

     for (Resource img : resources) {
         images.add(img.getFilename());
     }

 } */


