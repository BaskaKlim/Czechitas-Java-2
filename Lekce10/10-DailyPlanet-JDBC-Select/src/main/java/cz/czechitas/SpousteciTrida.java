package cz.czechitas;

import org.mariadb.jdbc.*;

public class SpousteciTrida {

    public static void main(String[] args) {
        MariaDbDataSource configDatabase = new MariaDbDataSource();
        configDatabase.setUser("student");
        configDatabase.setPassword("password");
        configDatabase.setUrl("jdbc:mysql://localhost:3306");
    }

}
