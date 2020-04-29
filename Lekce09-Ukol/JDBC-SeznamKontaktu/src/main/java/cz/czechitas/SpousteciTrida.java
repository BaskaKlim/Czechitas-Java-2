package cz.czechitas;

import java.sql.*;
import org.mariadb.jdbc.*;
import org.springframework.jdbc.core.*;

public class SpousteciTrida {

    public static void main(String[] args) throws SQLException {
        //instancia databazy
        MariaDbDataSource configDatabase = new MariaDbDataSource();
        //nastavenie databazy : url, user, passwort
        configDatabase.setUrl("jdbc:mysql://localhost:3306/SeznamKontaktu");
        configDatabase.setUser("student");
        configDatabase.setPassword("password");

        // pripojenie k databaze , argument konstruktoru je konfiguracia databazy -JDBC je database API, rovnako ako hibernate
        JdbcTemplate requestSender = new JdbcTemplate(configDatabase);

        //TODO: select 1 all object from database
         // ak idem pracovat s celym objektom, nie len jeho property, pouzijem RowMapper s instanciou nasej class-y daneho objektu
        RowMapper<Contact> mapper = BeanPropertyRowMapper.newInstance(Contact.class);

        Contact contact = requestSender.queryForObject("select * from kontakt where id =1", mapper);
        System.out.println(contact);
    }
}
