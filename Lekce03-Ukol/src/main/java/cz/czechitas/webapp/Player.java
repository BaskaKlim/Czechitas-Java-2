package cz.czechitas.webapp;

public class Player {

    String name;
    String surname;
    String email;

    int numberOfWins;
    int numberOfMatches;

    public Player() {
    }

    public Player(String name, String surname, String email, int numberOfWins, int numberOfMatches) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.numberOfWins = numberOfWins;
        this.numberOfMatches = numberOfMatches;
    }

    public String getName() {
        return name;
    }

    public void setName(String newValue) {
        name = newValue;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String newValue) {
        surname = newValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String newValue) {
        email = newValue;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int newValue) {
        numberOfWins = newValue;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public void setNumberOfMatches(int newValue) {
        numberOfMatches = newValue;
    }
}
