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

    RowMapper<Clanek> mapper;
    JdbcTemplate requestHandler;

    //konstruktor, ktory mi naplmi mapper a reqestHandler vzdy pri nacitani
    public JdbcClanekRepository() {
        try {
            MariaDbDataSource configDatabase = new MariaDbDataSource();
            configDatabase.setUser("student");
            configDatabase.setPassword("password");
            configDatabase.setUrl("jdbc:mysql://localhost:3306/DailyPlanet");

            mapper = BeanPropertyRowMapper.newInstance(Clanek.class);
            requestHandler = new JdbcTemplate(configDatabase);

        } catch (SQLException sqle) {
            throw new DataSourceLookupFailureException("Chyba pripojeni do databaze");
        }
    }

    @Override
    public List<Clanek> findAll() {
        String sql = "SELECT * FROM clanky";
        List<Clanek> clanky = requestHandler.query(sql, mapper);
        return clanky;
    }

    @Override
    public Clanek findById(Long id) {
        String sql = "SELECT * FROM customers WHERE id = ?";
        Clanek clanokViaID = requestHandler.queryForObject(sql, mapper, id);
        return clanokViaID;
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
        String sql = "DELETE FROM clanky WHERE id = ?";
        requestHandler.update(sql, id);
    }

    //<------ PRIVATE METHOD----------------------------->

    private void pridaj(Clanek zaznamPridani) {
        GeneratedKeyHolder hodlerGeneredKey = new GeneratedKeyHolder();
        String sql = "INSERT INTO clanky (nazev,autor,datum) VALUE (?,?,?)";

        requestHandler.update((Connection conn) -> {
                    PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    statement.setString(1, zaznamPridani.getNazev());
                    statement.setString(2, zaznamPridani.getAutor());
                    statement.setObject(3, zaznamPridani.getDatum());
                    return statement;
                },
                hodlerGeneredKey);
        zaznamPridani.setId(hodlerGeneredKey.getKey().longValue());
    }

    private void updatuj(Clanek zoznamUlozni) {
        String sql = "UPDATE clanky SET nazev = ?, autor = ?, datum = ? WHERE id = ?";

        requestHandler.update(sql,
                zoznamUlozni.getNazev(),
                zoznamUlozni.getAutor(),
                zoznamUlozni.getDatum(),
                zoznamUlozni.getId());

    }
}
