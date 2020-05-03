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
        
            MariaDbDataSource configDatabase = new MariaDbDataSource();
            configDatabase.setUser("student");
            configDatabase.setPassword("password");
            configDatabase.setUrl("jdbc:mysql://localhost:3306/VideoBoss");

            RowMapper<Clanek> mapper = BeanPropertyRowMapper.newInstance(Clanek.class);
            JdbcTemplate requestHandler = new JdbcTemplate(configDatabase);

            List<Clanek> clanky = requestHandler.query("SELECT * FROM clanky", mapper);

            return clanky;

    }

    @Override
    public Clanek findById(Long id) {
        throw new UnsupportedOperationException();
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
