package cz.czechitas.webapp;

import java.util.*;

public interface ArticleRepository {

    List<Article> showArticles();

    Article findArticleViaNumber(Long number);

    void saveArticle(DetailForm detailForm) ;

    void deleteArticleViaNumber(Long number);


}
