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

        JdbcTemplate requestSender = new JdbcTemplate();
        RowMapper<Article> mapper = BeanPropertyRowMapper.newInstance(Article.class);





    }

}
