package cz.czechitas.webapp.logika;

import java.util.*;
import org.springframework.stereotype.*;
import cz.czechitas.webapp.entity.*;
import cz.czechitas.webapp.persistence.*;

@Component
public class PexesoService {

    private PexesoRepository ulozisteHer;

    public PexesoService(PexesoRepository ulozisteHer) {
        this.ulozisteHer = ulozisteHer;
    }

    public HerniPlocha vytvorNovouHerniPlochu() {
        List<Karta> karticky = new ArrayList<>();
        int cisloKarty = 0;
        for (int i = 0; i < 8; i++) {
            karticky.add(vytvorKartu(cisloKarty));
            cisloKarty++;
            karticky.add(vytvorKartu(cisloKarty));
            cisloKarty++;
        }
        Collections.shuffle(karticky);
        HerniPlocha novaPlocha = new HerniPlocha(karticky, GameState.PLAYER1_CHOOSE_FIRST_CARD);
        novaPlocha = ulozisteHer.save(novaPlocha);
        return novaPlocha;
    }

    private Karta vytvorKartu(int cisloKarty) {
        return new Karta(cisloKarty, CardState.FACE_DOWN);
    }

    public HerniPlocha najdiHerniPlochu(Long id) {
        HerniPlocha aktualniPlocha = ulozisteHer.findById(id);
        return aktualniPlocha;
    }

    public void provedTah(Long idHerniPlochy, int poziceKartyNaKterouSeKliknulo) {
        HerniPlocha aktualniPlocha = ulozisteHer.findById(idHerniPlochy);

        if (aktualniPlocha.getStav() == GameState.PLAYER1_CHOOSE_FIRST_CARD) {
            vyberPrvniKartu(poziceKartyNaKterouSeKliknulo, aktualniPlocha);
        } else if (aktualniPlocha.getStav() == GameState.PLAYER1_CHOOSE_SECOND_CARD) {
            vyberDruhouKartu(poziceKartyNaKterouSeKliknulo, aktualniPlocha);
        } else if (aktualniPlocha.getStav() == GameState.PLAYER1_SHOW_RESULT) {
            List<Karta> karticky = vyhodnotOtoceneKarticky(aktualniPlocha);

            if (!jeKonecHry(karticky)) {
                aktualniPlocha.setStav(GameState.PLAYER1_CHOOSE_FIRST_CARD);
            } else {
                aktualniPlocha.setStav(GameState.END);
            }
        }

        ulozisteHer.save(aktualniPlocha);
    }

    private void vyberPrvniKartu(int poziceKartyNaKterouSeKliknulo, HerniPlocha aktualniPlocha) {
        Karta karticka = aktualniPlocha.getKarticky().get(poziceKartyNaKterouSeKliknulo);
        if (karticka.getStav() == CardState.FACE_DOWN) {
            karticka.setStav(CardState.FACE_UP);
            aktualniPlocha.setStav(GameState.PLAYER1_CHOOSE_SECOND_CARD);
        }
    }

    private void vyberDruhouKartu(int poziceKartyNaKterouSeKliknulo, HerniPlocha aktualniPlocha) {
        Karta karticka = aktualniPlocha.getKarticky().get(poziceKartyNaKterouSeKliknulo);
        if (karticka.getStav() == CardState.FACE_DOWN) {
            karticka.setStav(CardState.FACE_UP);
            aktualniPlocha.setStav(GameState.PLAYER1_SHOW_RESULT);

        }
    }

    private List<Karta> vyhodnotOtoceneKarticky(HerniPlocha aktualniPlocha) {
        List<Karta> karticky = aktualniPlocha.getKarticky();
        Karta karta1 = karticky.get(0);
        Karta karta2 = karticky.get(1);

        int i = 0;
        for (; i < karticky.size(); i++) {
            karta1 = karticky.get(i);
            if (karta1.getStav() == CardState.FACE_UP) break;
        }
        int j = i + 1;
        for (; j < karticky.size(); j++) {
            karta2 = karticky.get(j);
            if (karta2.getStav() == CardState.FACE_UP) break;
        }
        if (karta1.getCisloObrazku() == karta2.getCisloObrazku()) {
            karta1.setStav(CardState.COLLECTED);
            karta2.setStav(CardState.COLLECTED);
        } else {
            karta1.setStav(CardState.FACE_DOWN);
            karta2.setStav(CardState.FACE_DOWN);
        }
        return karticky;
    }

    private boolean jeKonecHry(List<Karta> karticky) {
        boolean jeKonec = true;
        for (Karta karta : karticky) {
            if (karta.getStav() != CardState.COLLECTED) {
                jeKonec = false;
            }
        }
        return jeKonec;
    }
}

