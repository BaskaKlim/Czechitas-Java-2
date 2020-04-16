package cz.czechitas.webapp;

import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HlavniController {
    private static final List<String> VYROKY = Arrays.asList(
            "There's no 'we' in fries.",
            "Be the reason someone smiles today...or the reason they drink. Whatever works.",
            "Nobody really cares if you’re miserable, so you might as well be happy.",
            "There's no 'we' in fries.",
            "Be the reason someone smiles today...or the reason they drink. Whatever works.",
            "Nobody really cares if you’re miserable, so you might as well be happy."
    );
    @RequestMapping("/")
    public ModelAndView zobrazIndex() {
        ModelAndView drzakNaDataAjmenoSablony = new ModelAndView("index");
        //vytvorenie random pocitadla a priradenie ho k vyrokom a obrazkom
        Random generatorNahodnychCisel = new Random();
        int nahodnyIndex = generatorNahodnychCisel.nextInt(VYROKY.size());
        String nahodnyVyrok = VYROKY.get(nahodnyIndex);
        // odoslanie informacii thymeleafu ake info sablone zasleme
        drzakNaDataAjmenoSablony.addObject("vyrok",nahodnyVyrok);
        drzakNaDataAjmenoSablony.addObject("cisloObrazka",nahodnyIndex);
        return drzakNaDataAjmenoSablony;
    }

}
