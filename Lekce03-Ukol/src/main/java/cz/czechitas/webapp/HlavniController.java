package cz.czechitas.webapp;

import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HlavniController extends Player {


    private  List<Player> players = Arrays.asList(
            new Player("Marburg", "Filoviridae", "email1@gmail.com", 2, 36),
            new Player("Ebola", "Filoviridae", "email2@gmail.com", 10, 36),
            new Player("Besnota", "Rabies", "email3@gmail.com", 5, 36),
            new Player("Kiahne", "Aricella", "email4@gmail.com", 5, 36),
            new Player("Hantavírus", "Bunyaviridae", "email5@gmail.com", 2, 36),
            new Player("Koronavírus", "COVID-9", "email6@gmail.com", 7, 36),
            new Player("Rotavírus", "Reoviridae", "email7@gmail.com", 2, 36),
            new Player("Dengue", " Flaviviridae", "email8@gmail.com", 3, 36)
    );

    @RequestMapping("/")
    public ModelAndView zobrazIndex() {
        ModelAndView drzakNaDataANazevSablony = new ModelAndView("index");
        Random random = new Random();
        List<String> pexeso = new ArrayList<>();
        //mam 6x4 - 24 pole pexesa
        for (int x = 0; x < 8; x++) {
            int randomIndex = random.nextInt(31)+1; // mam 32 kariet od 0 po 31 ale cislovane su od 1 preto +1
            pexeso.add("pex" + randomIndex);
            pexeso.add("rub");
            pexeso.add("pex" + randomIndex);
            pexeso.add("rub");
        }

        Collections.shuffle(pexeso);
        drzakNaDataANazevSablony.addObject("pexeso", pexeso);
        return drzakNaDataANazevSablony;
    }

}
