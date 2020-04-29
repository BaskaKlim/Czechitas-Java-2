package cz.czechitas;

import java.sql.*;
import java.util.*;
import org.mariadb.jdbc.*;
import org.springframework.dao.*;
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

        // ak idem pracovat s celym objektom, nie len jeho property, pouzijem RowMapper s instanciou nasej class-y daneho objektu
        RowMapper<Contact> mapper = BeanPropertyRowMapper.newInstance(Contact.class);

        //TODO: select 1 all object from database
        Contact contactByID = requestSender.queryForObject("SELECT * FROM kontakt WHERE id =4", mapper);
        String nameOfcontactByEmail = requestSender.queryForObject("SELECT jmeno FROM kontakt WHERE email='thomas@edison.com'",String.class);
        System.out.println("Kontakt s ID 4 je: " + contactByID);
        System.out.println("Kontakt s mailom tomas@edison.com patri cloveku s menom  : " + nameOfcontactByEmail);

        //TODO: select all contacts
        //pracujem s viacerymi objektmi, cize listom. Je potrebne pouzit funkciu .query nie .queryForObject a zaroven na vypisanie listu pouzit forEach

        List<Contact> allContacts = requestSender.query("SELECT * FROM kontakt", mapper);
        System.out.println("Zoznam kontaktov: \n");
        for (Contact eachCustomer : allContacts) {
            System.out.println(eachCustomer);

        }
        

    }
}
