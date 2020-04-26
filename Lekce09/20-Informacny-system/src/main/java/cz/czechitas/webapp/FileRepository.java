package cz.czechitas.webapp;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.regex.*;
import org.springframework.stereotype.*;

@Repository
public class FileRepository implements ArticleRepository {

    public static final Path PATH_TO_FILE = Paths.get("data.csv");
    public static final Pattern REGEX_ROW = Pattern.compile("([0-9]+)[,;]\"(.*?)\"[,;]\"(.*?)\"[,;]([0-9]{4}-[0-9]{1,2}-[0-9]{1,2})");

    private Long keyNumber  = 3000L;

    /*Interface methods*/

    @Override
    public List<Article> showArticles() {
       
    }

    @Override
    public Article findArticleViaNumber(Long number) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void saveArticle(DetailForm detailForm) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteArticleViaNumber(Long number) {
        throw new UnsupportedOperationException();
    }



}