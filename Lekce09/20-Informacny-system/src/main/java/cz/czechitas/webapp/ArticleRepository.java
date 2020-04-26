package cz.czechitas.webapp;

import java.util.*;

public interface ArticleRepository {

    List<Article> findAll();

    Article findArticleViaNumber(Long number);

    void saveArticle(DetailForm detailForm) ;

    void deleteArticleViaNumber(Long number);


}
