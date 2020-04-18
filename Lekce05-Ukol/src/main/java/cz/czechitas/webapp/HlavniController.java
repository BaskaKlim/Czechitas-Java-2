package cz.czechitas.webapp;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HlavniController {


    @RequestMapping(value = "/", method = RequestMethod.GET)

    public ModelAndView zobrazIndex() {
        ModelAndView modelAndViewhandler = new ModelAndView("index");
        return modelAndViewhandler;
    }




    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView zobrazResult(HipsterProperties vyplnenyFormular) {
        ModelAndView modelAndViewhandler = new ModelAndView("result");

        int numberOfCamels = 0;

        String message = "";

        int age = vyplnenyFormular.getAge();
        numberOfCamels = (age > 25) ? numberOfCamels + 20 : numberOfCamels + 35;

        int height = vyplnenyFormular.getHeight();
        numberOfCamels = (height < 160) ? numberOfCamels - 5 : numberOfCamels + 25;

        String haircolor = vyplnenyFormular.getHaircolor();
        if (haircolor == "blonde" || haircolor == "red") {
            numberOfCamels += 20;
        } else if (haircolor == "brown" || haircolor == "black") {
            numberOfCamels -= 5;
        } else if (haircolor == "grey") {
            numberOfCamels *= 2;
        }

        String hairlength = vyplnenyFormular.getHairlenght();
        if (hairlength == "long" || haircolor == "bald") {
            numberOfCamels += 20;
        } else if (hairlength == "short" || hairlength == "middle") {
            numberOfCamels += 10;
        }

        String eyecolor = vyplnenyFormular.getEyecolor();
        if (eyecolor == "blue") {
            numberOfCamels *= 2;
        } else if (eyecolor == "brown") {
            numberOfCamels /= 2;
        } else if (eyecolor == "grey") {
            numberOfCamels *= 3;
        } else if (eyecolor == "green") {
            numberOfCamels += 15;
        }

        String beard = vyplnenyFormular.getBeard();
        numberOfCamels = (beard == "large" || beard == "middle") ? numberOfCamels + 20 : numberOfCamels - 10;

        String style = vyplnenyFormular.getStyle();
        numberOfCamels = (style == "h1" || style == "h2") ? numberOfCamels + 30 : numberOfCamels + 15;

        //logika za message

        if (numberOfCamels < 30) {
            message = "Och, poor hipster, he is worth just less than 30 camels";
        } else if (numberOfCamels > 29 && numberOfCamels < 90) {
            message = "Hmm ok, we can make a deal!";
        } else
            message = "Olalaaa,I want to do big business with you!";

        // pridanie klucu pre thymeleaf
        modelAndViewhandler.addObject("age", age);
        modelAndViewhandler.addObject("height", height);
        modelAndViewhandler.addObject("haircolor", haircolor);
        modelAndViewhandler.addObject("hairlength", hairlength);
        modelAndViewhandler.addObject("eyecolor", eyecolor);
        modelAndViewhandler.addObject("beard", beard);
        modelAndViewhandler.addObject("style", style);
        modelAndViewhandler.addObject("numberOfCamels",numberOfCamels);
        modelAndViewhandler.addObject("message",message);

        return modelAndViewhandler;
    }





}
