package cz.czechitas.webapp;

import java.sql.*;
import java.util.*;
import org.mariadb.jdbc.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.lookup.*;
import org.springframework.jdbc.support.*;
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
        //overim si ci uz id= primary kluc existuje v zazame
        if (zaznamKUlozeni.getId() == null) {
            //vytvoreni zaznamu
            pridaj(zaznamKUlozeni);
        } else {
            //aktualizacia zaznamu
            updatuj(zaznamKUlozeni);
        }
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException();
    }

    //<------ PRIVATE METHOD----------------------------->

    private void pridaj(Clanek zaznamPridani) {
        GeneratedKeyHolder hodlerGeneredKey = new GeneratedKeyHolder();
        String sql = "INSERT INTO clanky (nazev,autor,datum) VALUE (?,?,?)";
        try {
            MariaDbDataSource configDatabase = new MariaDbDataSource();
            configDatabase.setUser("student");
            configDatabase.setPassword("password");
            configDatabase.setUrl("jdbc:mysql://localhost:3306/DailyPlanet");

            RowMapper<Clanek> mapper = BeanPropertyRowMapper.newInstance(Clanek.class);
            JdbcTemplate requestHandler = new JdbcTemplate(configDatabase);

            requestHandler.update((Connection conn) -> {
                        PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                        statement.setString(1, zaznamPridani.getNazev());
                        statement.setString(2, zaznamPridani.getAutor());
                        statement.setObject(3, zaznamPridani.getDatum());
                        return statement;
                    },
                    hodlerGeneredKey);
            zaznamPridani.setId(hodlerGeneredKey.getKey().longValue());
        } catch (SQLException sqle) {
            throw new DataSourceLookupFailureException("Chyba pripojeni do databaze");
        }
    }

    private void updatuj(Clanek zoznamUlozni) {

    }
}
