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

        Long numberOfCustomers = requestSender.queryForObject("select count (*) from customers", Long.class);

        System.out.println("V databaze je " + numberOfCustomers + " zakaznikov");

        //TODO: ziskej jmeno zakasnika s ID 22
        // queryForObject(select , return type.class )
        String nameOfCustomer22 = requestSender.queryForObject("select concat(firstname, ' ', lastname) from customers where id=22", String.class);
        System.out.println("Meno zakaznika s ID 22 je  " + nameOfCustomer22);

        //TODO: ziskaj celeho zakaznika //
        //mapovanie dat z databazy na objekt
        RowMapper<Customer> prevodnik = BeanPropertyRowMapper.newInstance(Customer.class);
        Customer customer = requestSender.queryForObject("select * from customer where id =22", prevodnik);

        System.out.println("Zakaznik  " + customer);
    }

}
