package cz.czechitas;

import java.sql.*;
import org.mariadb.jdbc.*;
import org.springframework.jdbc.core.*;

public class SpousteciTrida {

    public static void main(String[] args) throws SQLException {
        //instancia databazy
        MariaDbDataSource configDatabase = new MariaDbDataSource();
        //nastavenie databazy : url, user, passwort
        configDatabase.setUrl("jdbc:mysql://localhost:3306/VideoBoss");
        configDatabase.setUser("student");
        configDatabase.setPassword("password");

        // pripojenie k databaze , argument konstruktoru je konfiguracia databazy -JDBC je database API, rovnako ako hibernate
        JdbcTemplate requestSender = new JdbcTemplate(configDatabase);
    }

}
