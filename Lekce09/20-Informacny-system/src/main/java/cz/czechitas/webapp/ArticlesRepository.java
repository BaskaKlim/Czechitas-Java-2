package cz.czechitas.webapp;

import java.util.*;
import java.util.concurrent.*;
import org.springframework.stereotype.*;

@Repository

public class ArticlesRepository {

    private Long keyNumber = 1000L;

    /* using CopyOnWriteArrayList because it can handle multiple requests in runtime in the same time*/
    private List<Article> articles = new CopyOnWriteArrayList<>(Arrays.asList(
            //create articles via using full constructor
            new Article(keyNumber++, "Clark Kent", "Last metheroid"),
            new Article(keyNumber++, "Loise Leinova", "Forever in love"),
            new Article(keyNumber++, "Lex Luthor", "I will be back")
    ));



    public List<Article> getArticles(){
        return articles;
    }


    public void saveArticle(DetailForm detailForm) {
        //vytiahnem si informacie z formulara do novych premennych
        String title = detailForm.getTitle();
        String author = detailForm.getAuthor();
        Article newArticle = new Article(keyNumber++, title, author);
        articles.add(newArticle);

    }

    //na vstupe identifikator clanku a jeho upravene informace
    public void editArticle(Long number, DetailForm detailForm) {

        /** 1. postup skrz index **/
       /*
        //ziska si poziciu
        int index = getIndexViaNumber(number);
         //vytiahne zo zoznamu
          Article editingArticle =  articles.get(index);
        //zmeni mu pozadovane vlastnosti    updatnute z formulare
        editingArticle.setTitle(detailForm.getTitle());
        editingArticle.setAuthor(detailForm.getAuthor());
         */

        /** 2. postup s for each cyklom **/
        for (Article article : articles) {
            //zisti, ci je to clanok, ktory hladas - porovnanim cisla, nemas identifikator index
            if (article.getNumber().equals(number)) {
                article.setTitle(detailForm.getTitle());
                article.setAuthor(detailForm.getAuthor());
            }
        }
    }

    public Article findArticleViaNumber(Long number) {
        int index = getIndexViaNumber(number);
        return articles.get(index);
    }

    public int getIndexViaNumber(Long number) {
        //need to find identificator of position of article
        for (int i = 0; i < articles.size(); i++) {  //ziskam index i - aktualny index na ktorom stojim vramci cyklu
            if (articles.get(i).getNumber().equals(number)) {
                return i;
            }

        }
        return -1;
    }

    public void deleteArticleViaNumber(Long number) {
        int index = getIndexViaNumber(number);
        articles.remove(index);

    }
}
