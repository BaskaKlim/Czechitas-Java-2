package cz.czechitas.webapp;

import java.sql.*;
import java.util.*;
import org.mariadb.jdbc.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.lookup.*;
import org.springframework.stereotype.*;

@Repository
public class JdbcClanekRepository implements ClanekRepository {

    @Override
    public List<Clanek> findAll() {

        try {
            MariaDbDataSource configDatabase = new MariaDbDataSource();
            configDatabase.setUser("student");
            configDatabase.setPassword("password");
            configDatabase.setUrl("jdbc:mysql://localhost:3306/DailyPlanet");

            RowMapper<Clanek> mapper = BeanPropertyRowMapper.newInstance(Clanek.class);
            JdbcTemplate requestHandler = new JdbcTemplate(configDatabase);

            List<Clanek> clanky = requestHandler.query("SELECT * FROM clanky", mapper);

            return clanky;

        } catch (SQLException sqle) {
            throw new DataSourceLookupFailureException("Chyba pripojeni do databaze");
        }

    }

    @Override
    public Clanek findById(Long id) {
        try {
            MariaDbDataSource configDatabase = new MariaDbDataSource();
            configDatabase.setUser("student");
            configDatabase.setPassword("password");
            configDatabase.setUrl("jdbc:mysql://localhost:3306/DailyPlanet");

            RowMapper<Clanek> mapper = BeanPropertyRowMapper.newInstance(Clanek.class);
            JdbcTemplate requestHandler = new JdbcTemplate(configDatabase);

            Clanek clanokViaID = requestHandler.queryForObject("SELECT * FROM customers WHERE id = ?", mapper, id);
            return clanokViaID;
            
        } catch (SQLException sqle) {
            throw new DataSourceLookupFailureException("Chyba pripojeni do databaze");
        }

    }

    @Override
    public void save(Clanek zaznamKUlozeni) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException();
    }
}
