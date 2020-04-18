package cz.czechitas.webapp;

public class Contact {

    private Long id;
    private String name;
    private String telephoneNumber;
    private String email;

    public Contact(){

    }

    public Contact(String name, String telephoneNumber, String email) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    public Contact(Long id, String name, String telephoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long newValue) {
        id = newValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String newValue) {
        name = newValue;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String newValue) {
        telephoneNumber = newValue;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String newValue) {
        email = newValue;
    }
}
