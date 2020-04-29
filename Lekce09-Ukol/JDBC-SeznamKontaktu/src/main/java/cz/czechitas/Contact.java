package cz.czechitas;

public class Contact {

    Long id;
    String jmeno;
    String telefonniCislo;
    String email;

    public Long getId() {
        return id;
    }

    public void setId(Long newValue) {
        id = newValue;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String newValue) {
        jmeno = newValue;
    }

    public String getTelefonniCislo() {
        return telefonniCislo;
    }

    public void setTelefonniCislo(String newValue) {
        telefonniCislo = newValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String newValue) {
        email = newValue;
    }

    @Override
    public String toString() {
        return "Contact " +
                "id=" + id + ", " +
                "jmeno=\"" + jmeno + "\"" + ", " +
                "telefonniCislo=\"" + telefonniCislo + "\"" + ", " +
                "email=\"" + email + "\"";
    }
}
