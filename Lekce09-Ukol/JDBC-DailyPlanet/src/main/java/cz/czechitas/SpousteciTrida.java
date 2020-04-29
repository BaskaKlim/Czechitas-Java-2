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

    }
}
