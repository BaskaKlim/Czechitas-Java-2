package cz.czechitas.webapp;

public class Hrac {
    String name;
    String lastname;
    int age;

    public Hrac(String name, String lastname, int age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String newValue) {
        name = newValue;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String newValue) {
        lastname = newValue;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newValue) {
        age = newValue;
    }
}
