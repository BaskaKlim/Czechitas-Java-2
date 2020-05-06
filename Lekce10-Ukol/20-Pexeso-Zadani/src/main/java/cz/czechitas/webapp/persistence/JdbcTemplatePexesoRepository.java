package cz.czechitas.webapp.persistence;


import java.sql.*;
import java.util.*;
import org.mariadb.jdbc.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.lookup.*;
import org.springframework.stereotype.*;
import cz.czechitas.webapp.entity.*;

@Repository
public class JdbcTemplatePexesoRepository implements PexesoRepository{
    private Random random;

    RowMapper<HerniPlocha> mapper;
    JdbcTemplate requestHandler;

    //construnctor with mariadb config
    public JdbcTemplatePexesoRepository() {
        try {
            MariaDbDataSource configDatabase = new MariaDbDataSource();
            configDatabase.setUser("student");
            configDatabase.setPassword("password");
            configDatabase.setUrl("jdbc:mysql://localhost:3306/DailyPlanet");

            mapper = BeanPropertyRowMapper.newInstance(HerniPlocha.class);
            requestHandler = new JdbcTemplate(configDatabase);

        } catch (SQLException sqle) {
            throw new DataSourceLookupFailureException("Chyba pripojeni do databaze");
        }
    }

    @Override
    public HerniPlocha findById(Long id) {
        HerniPlocha herniPlocha = seznamHernichPloch.get(id);
        if (herniPlocha == null) {
            throw new NeexistujiciHraException();
        }
        return herniPlocha;
    }

    @Override
    public HerniPlocha save(HerniPlocha plocha) {
        if (plocha.getId() == null) {
            plocha.setId(vygenerujNahodneId());
            for (Karta karta : plocha.getKarticky()) {
                karta.setId(vygenerujNahodneId());
            }
        }
        seznamHernichPloch.put(plocha.getId(), plocha);
        return plocha;
    }

    //-------------PRIVATE METHODS------------------------------------------------------------
    private Long vygenerujNahodneId() {
        return (long) Math.abs(random.nextInt());
    }

}
