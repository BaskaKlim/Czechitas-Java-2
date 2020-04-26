package cz.czechitas;

import java.sql.*;
import org.mariadb.jdbc.*;
import org.springframework.jdbc.core.*;

public class SpousteciTrida {

    public static void main(String[] args) throws SQLException {
        //instancia databazy
        MariaDbDataSource configDatabase = new MariaDbDataSource();
        //nastavenie databazy
        configDatabase.setUrl("jdbc:mysql://localhost:3306/VideoBoss");
        configDatabase.setUserName("student");
        configDatabase.setUserName("password");
        // pripojenie k databaze , argument konstruktoru je konfiguracia databazy
        JdbcTemplate requestSender = new JdbcTemplate(configDatabase);

        //TODO: zisti kolko je pocet zapisov = zakaznikov v databaze

        Long numberOfClients = requestSender.queryForObject("select count (*) from customers", Long.class);

        System.out.println("V databaze je " + numberOfClients + " zakaznikov");

        //TODO: ziskej jmeno zakasnika s ID 22
                                                              // queryForObject(select , return type.class )
        String nameOfClient22 = requestSender.queryForObject("select concat(firstname, ' ', lastname) from customers where id=22", String.class);
        System.out.println("Meno zakaznika s ID 22 je  " + nameOfClient22);

    }

}
