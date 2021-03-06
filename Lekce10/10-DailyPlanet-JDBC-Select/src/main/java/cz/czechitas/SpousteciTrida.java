package cz.czechitas;

import java.sql.*;
import org.mariadb.jdbc.*;
import org.springframework.jdbc.core.*;

public class SpousteciTrida {

    public static void main(String[] args) throws SQLException {
        MariaDbDataSource configDatabase = new MariaDbDataSource();
        configDatabase.setUser("student");
        configDatabase.setPassword("password");
        configDatabase.setUrl("jdbc:mysql://localhost:3306/VideoBoss");

        RowMapper<Customer> mapper = BeanPropertyRowMapper.newInstance(Customer.class);
        JdbcTemplate requestHandler = new JdbcTemplate(configDatabase);

        //provedeni dotazu do databaze
        Long id = 14L;
        Customer customerViaID = requestHandler.queryForObject("SELECT * FROM customers WHERE id = ?", mapper, id);
        System.out.println(customerViaID);
    }
}



