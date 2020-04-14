package cz.czechitas.webapp;

/**
 * Tato trieda obsahuje 3 vlastnosti: celeJmeno (R/O), firstName(R/W) a lastName (R/W)
 *
 */
public class JmenoForm {


    private String firstName;
    private String lastName;
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newValue) {
        firstName = newValue;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newValue) {
        lastName = newValue;
    }
}
