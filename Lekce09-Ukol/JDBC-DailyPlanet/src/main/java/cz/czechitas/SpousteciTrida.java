package cz.czechitas;

import java.sql.*;
import java.util.*;
import org.mariadb.jdbc.*;
import org.springframework.dao.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.*;

public class SpousteciTrida {

    public static void main(String[] args) throws SQLException {
        MariaDbDataSource config = new MariaDbDataSource();
        config.setUrl("jdbc:mysql://localhost:3306/DailyPlanet");
        config.setUser("student");
        config.setPassword("password");

        JdbcTemplate requestSender = new JdbcTemplate(config);
        RowMapper<Article> mapper = BeanPropertyRowMapper.newInstance(Article.class);

        //TODO 1: select 1 all object from database

        Long id = 2L;
        String title = "Lidé doma hromadí léky";

        Article articlebyID = requestSender.queryForObject("SELECT * FROM clanky WHERE ID=?", mapper, id);
        String authorOfArticleByTitle = requestSender.queryForObject("SELECT autor FROM clanky WHERE nazev=?", String.class, title);

        System.out.println("Clanok s id 2 : " + articlebyID + "\n"
                + "Autor clanku s nazvom " + title + "je: " + authorOfArticleByTitle + "\n");

        //TODO 2: select all articles

        List<Article> articles = requestSender.query("SELECT * FROM clanky", mapper);
        System.out.println("Zoznam clanku: ");
        for (Article eachArticle : articles) {
            System.out.println(eachArticle);
        }

        //TODO 3: Insert new article

        String newTitle = "Kedy to skonci";
        String newAuthor = "Corona Virosis";
        String newDate = "2020-12-30";

        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        requestSender
                .update((Connection conn) -> {
                            PreparedStatement statement = conn.prepareStatement("INSERT INTO clanky (nazev, autor, datum) " +
                                    "VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                            statement.setString(1, newTitle);
                            statement.setString(2, newAuthor);
                            statement.setString(3, newDate);
                            return statement;
                        },
                        generatedKeyHolder);

        //print cely zoznam
        System.out.println("\n");
        List<Article> articlesWithNEW = requestSender.query("SELECT * FROM clanky", mapper);
        for (Article eachArticle : articlesWithNEW) {
            System.out.println(eachArticle);
        }
        System.out.println("\n");

        //TODO 4 :Update an article with id 14

        String updatedAutor = "Mikulas Kopernikus";
        requestSender.update("UPDATE clanky SET Autor=? where id = 14", updatedAutor);
        Article updateContact = requestSender.queryForObject("SELECT * FROM clanky WHERE id =14", mapper);
        System.out.println("\n" + "Update clanok: " + updateContact + "\n");

        //TODO 4 :Delete an article with  title "Nový japonský císař         "

        GeneratedKeyHolder generatedKeyHolderOfDeleteRequest = new GeneratedKeyHolder();
        String deletedName = "Nový japonský císař";
        requestSender
                .update((Connection con) -> {
                    PreparedStatement StatementDelete = con.prepareStatement("DELETE FROM clanky WHERE nazev = ?", Statement.RETURN_GENERATED_KEYS);
                    StatementDelete.setString(1, deletedName);
                    return StatementDelete;
                }, generatedKeyHolderOfDeleteRequest);

        System.out.println("\n");
        List<Article> articlesWithoutDELETED = requestSender.query("SELECT * FROM clanky", mapper);
        for (Article eachArticle : articlesWithoutDELETED) {
            System.out.println(eachArticle);
        }
        System.out.println("\n");
    }
}

