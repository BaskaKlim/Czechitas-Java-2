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
    private List<Boolean> trues;

    public HlavniController() throws IOException {
        ResourcePatternResolver fileSearcher = new PathMatchingResourcePatternResolver();
        List<Resource> resources = Arrays.asList(fileSearcher.getResources("classpath:/static/images/faces/*"));

        images = new ArrayList<>(resources.size());
        for (Resource prvek : resources) {
            images.add(prvek.getFilename());
        }
        // logic algorithms for true or false answer
        trues = new ArrayList<>();
        for (String image : images) {
            if (image.contains("T")) {
                trues.add(true);
            } else {
                trues.add(false);
            }
        }

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)

    public ModelAndView zobrazIndex() {
        ModelAndView modelAndViewhandler = new ModelAndView("inde");
        Collections.shuffle(images);

        modelAndViewhandler.addObject("images", images);
        return modelAndViewhandler;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView vratIndex(HomelessFacesForm dataForm) {
        int score = 0;
        String message;
        boolean answer;
        boolean rightAnswer;

        for (int i = 0; i < dataForm.getAnswer().size(); i++) {
            answer = dataForm.getAnswer().get(i);
            rightAnswer = trues.get(i);
            if (answer == rightAnswer) {
                score++;
            }
        }

        if (score < 3) {
            message = "Are you kidding me? You really do not see the difference";
        } else if (score > 2 && score < 6) {
            message = "Hmm ok, you are not a detective, but your score is not shame";
        } else
            message = "Olalaaa,FBI agent!";

        ModelAndView dataHandler = new ModelAndView("result");
        dataHandler.addObject("score", score);
        dataHandler.addObject("message", message);
        return dataHandler;
    }

}

