package cz.czechitas.webapp;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.regex.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.server.*;
import com.sun.java.util.jar.pack.*;

@Repository
public class FileRepository implements ArticleRepository {

    public static final Path PATH_TO_FILE = Paths.get("data.csv");
    public static final Pattern REGEX_ROW = Pattern.compile("([0-9]+)[,;]\"(.*?)\"[,;]\"(.*?)\"[,;]([0-9]{4}-[0-9]{1,2}-[0-9]{1,2})");

    private Long keyNumber = 3000L;

    /*Interface methods*/

    @Override
    public List<Article> showArticles() {
        return loadDataFromFile();

    }

    @Override
    public Article findArticleViaNumber(Long number) {
        List<Article> articles = showArticles();
        int index = najdiIndexZaznamu(articles, number);
        return clone(articles.get(index));
    }

    public void saveArticle(Article savingArticle) {
        List<Article> articles = showArticles();
        if (savingArticle.getNumber() != null) {
            int index = najdiIndexZaznamu(articles, savingArticle.getNumber());
            if (index != -1) {
                editArticle(articles, savingArticle, index);
                return;
            }
        }
        addArticle(articles, savingArticle);

    }

    @Override
    public void deleteArticleViaNumber(Long number) {
        List<Article> articles = showArticles();
        int index = najdiIndexZaznamu(articles, number);
        if (index == -1) return;
        articles.remove(index);
        saveDataToFile(articles);
    }
    /*Methods for action with article */

    public void editArticle(List<Article> articles, Article savingArticle, int index) {
        Article article = clone(savingArticle);
        articles.set(index, article);
        saveDataToFile(articles);
    }

    private void addArticle(List<Article> articles, Article articlesForSaving) {
        Article article = clone(articlesForSaving);
        article.setNumber(keyNumber);
        keyNumber = keyNumber + 1L;
        articles.add(article);
        saveDataToFile(articles);
    }

    private int najdiIndexZaznamu(List<Article> articles, Long number) {
        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            if (article.getNumber().equals(number)) {
                return i;
            }
        }
        return -1;
    }


    /* Methods for action with file */

    private List<Article> loadDataFromFile() {
        try {
            //riadky z file
            List<String> rows = Files.readAllLines(PATH_TO_FILE, StandardCharsets.UTF_8);
            // list clankov je zoznam riadkov (jeden riadok jeden zaznam)
            List<Article> articles = new ArrayList<>(rows.size());
            // pre kazdy riadok zo suboru vytvor string riadok v pamati
            for (String row : rows) {
                Matcher regularniAutomat = REGEX_ROW.matcher(row);
                if (!regularniAutomat.find()) continue;

                Article oneArticle = new Article(
                        Long.parseLong(regularniAutomat.group(1)),
                        regularniAutomat.group(2),
                        regularniAutomat.group(3)
                );
                articles.add(oneArticle);
            }
            return articles;
        } catch (IOException e) {
            throw new RuntimeException("Nepodařilo se načíst data ze souboru " + PATH_TO_FILE + ": " + e.getMessage(), e);
        }
    }

    private void saveDataToFile(List<Article> articles) {
        try {
            List<String> rows = new ArrayList<>(articles.size());
            for (Article oneArticle : articles) {
                //format, v akom ma byt zapis

                String row = oneArticle.getNumber() + ",\""
                        + oneArticle.getTitle() + "\",\""
                        + oneArticle.getAuthor() + "\"";
                rows.add(row);
            }
            //zapis do file
            Files.write(PATH_TO_FILE, rows, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Nepodařilo se uložit data do souboru " + PATH_TO_FILE + ": " + e.getMessage(), e);
        }
    }

    // method for cloning an article
    private Article clone(Article original) {
        return new Article(original.getNumber(), original.getTitle(), original.getAuthor());
    }

}