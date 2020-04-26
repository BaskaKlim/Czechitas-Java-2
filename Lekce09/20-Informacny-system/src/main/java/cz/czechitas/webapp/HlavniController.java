package cz.czechitas.webapp;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HlavniController {

    RAMRepository articles;

    public HlavniController(RAMRepository articles){
        this.articles =articles;

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView zobrazIndex() {
        //redirect to another web adesss
        return new ModelAndView("redirect:/seznam");
    }

    @RequestMapping(value = "/seznam", method = RequestMethod.GET)
    public ModelAndView zobrazSeznam() {
        ModelAndView modelAndViewhandler = new ModelAndView("inde");
        //adding object to MVC articles, that i want to use in thymeleaf in html
        modelAndViewhandler.addObject("articles", articles.showArticles());
        return modelAndViewhandler;
    }

    @RequestMapping(value = "/seznam/{number}", method = RequestMethod.POST, params = "_method=DELETE")
    public ModelAndView zmazClatok(@PathVariable("number") Long number) {

        articles.deleteArticleViaNumber(number);
        return new ModelAndView("redirect:/seznam");
    }

    //variable path calling from server - detail1, detail 2, detail3 ...
    @RequestMapping(value = "/detail{number}", method = RequestMethod.GET)
    public ModelAndView zobrazDetail(@PathVariable("number") Long number) {
        ModelAndView modelAndViewhandler = new ModelAndView("detail");
        modelAndViewhandler.addObject("article", articles.findArticleViaNumber(number));
        return modelAndViewhandler;
    }

    @RequestMapping(value = "/detail{number}", method = RequestMethod.POST)
    public ModelAndView vratDetail(@PathVariable("number") Long number, DetailForm detailForm) {
        articles.editArticle(number, detailForm);
        return new ModelAndView("redirect:/seznam");
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView zobrazNew() {
        ModelAndView modelAndViewHandler = new ModelAndView("detail");
        modelAndViewHandler.addObject("article", new DetailForm());
        return modelAndViewHandler;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ModelAndView spracujNew(DetailForm detailForm) {
        articles.saveArticle(detailForm);
        return new ModelAndView("redirect:/seznam");
    }

}
