package cz.czechitas.webapp.persistence;

import java.sql.*;
import java.time.*;
import java.util.*;
import org.mariadb.jdbc.*;
import org.springframework.dao.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.lookup.*;
import org.springframework.jdbc.support.*;
import org.springframework.stereotype.*;
import cz.czechitas.webapp.entity.*;

@Component
public class JdbcTemplatePexesoRepository implements PexesoRepository {

    RowMapper<HerniPlocha> boardMapper;
    RowMapper<Karta> cardMapper;
    private JdbcTemplate requestHandler;

    //construnctor with mariadb config
    public JdbcTemplatePexesoRepository() {

        try {
            MariaDbDataSource configDatabase = new MariaDbDataSource();
            configDatabase.setUser("student");
            configDatabase.setPassword("password");
            configDatabase.setUrl("jdbc:mysql://localhost:3306/Pexeso");

            boardMapper = BeanPropertyRowMapper.newInstance(HerniPlocha.class);
            cardMapper = BeanPropertyRowMapper.newInstance(Karta.class);
            requestHandler = new JdbcTemplate(configDatabase);

        } catch (SQLException sqle) {
            throw new DataSourceLookupFailureException("Chyba pripojeni do databaze");
        }

    }

    @Override
    public HerniPlocha findById(Long id) {
        try {
            HerniPlocha herniPlocha = requestHandler.queryForObject(
                    "SELECT ID, Stav FROM HerniPlochy WHERE ID = ?",
                    boardMapper,
                    id);
            List<Karta> karticky = requestHandler.query(
                    "SELECT ID, CisloKarty, Stav FROM Karty WHERE HerniPlochaID = ?",
                    cardMapper,
                    id);
            herniPlocha.setKarticky(karticky);
            return herniPlocha;
        } catch (EmptyResultDataAccessException e) {
            throw new NeexistujiciHraException();
        }
    }

    @Override
    public HerniPlocha save(HerniPlocha plocha) {
        if (plocha.getId() == null) {
            return this.pridejHerniPlochu(plocha);
        }
        return this.updatuj(plocha);
    }

    //-------------PRIVATE METHODS------------------------------------------------------------

    private void pridejKarticku(Karta karticka, Long plochaId, int poradiKarty) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO karty (CisloKarty, Stav, HerniPlochaID, PoradiKarty) " +
                "VALUES (?, ?, ?, ?)";
        requestHandler.update((Connection con) -> {
                    PreparedStatement prikaz = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    prikaz.setInt(1, karticka.getCisloKarty());
                    prikaz.setString(2, karticka.getStav().name());
                    prikaz.setLong(3, plochaId);
                    prikaz.setInt(4, poradiKarty);
                    return prikaz;
                },
                generatedKeyHolder);
        karticka.setId(generatedKeyHolder.getKey().longValue());
    }

    private HerniPlocha pridejHerniPlochu(HerniPlocha plocha) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO herniplochy (Stav, CasPoslednihoTahu) " +
                "VALUES (?, ?)";
        requestHandler.update((Connection con) -> {
                    PreparedStatement prikaz = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    prikaz.setString(1, plocha.getStav().name());
                    prikaz.setObject(2, Instant.now());
                    return prikaz;
                },
                generatedKeyHolder);
        plocha.setId(generatedKeyHolder.getKey().longValue());

        List<Karta> karticky = plocha.getKarticky();
        for (int i = 0; i < karticky.size(); i++) {
            Karta karticka = karticky.get(i);
            pridejKarticku(karticka, plocha.getId(), i);
        }
        return plocha;
    }

    private HerniPlocha updatuj(HerniPlocha plocha) {
        requestHandler.update(
                "UPDATE herniplochy SET Stav = ?, CasPoslednihoTahu = ? WHERE ID = ?",
                plocha.getStav().name(),
                Instant.now(),
                plocha.getId());

        List<Karta> karticky = plocha.getKarticky();
        for (int i = 0; i < karticky.size(); i++) {
            Karta karticka = karticky.get(i);
            requestHandler.update(
                    "UPDATE karty SET Stav = ?, PoradiKarty = ? WHERE ID = ?",
                    karticka.getStav().name(),
                    i,
                    karticka.getId());
        }

        return plocha;
    }
}
